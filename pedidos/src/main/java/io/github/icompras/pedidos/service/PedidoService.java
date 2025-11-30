package io.github.icompras.pedidos.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.icompras.pedidos.client.ServicoBancoClient;
import io.github.icompras.pedidos.model.Pedido;
import io.github.icompras.pedidos.model.enums.StatusPedido;
import io.github.icompras.pedidos.repository.ItemPedidoRepository;
import io.github.icompras.pedidos.repository.PedidoRepository;
import io.github.icompras.pedidos.validator.PedidoValidator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
// Cria um construtor com todo os argumentos obrigatórios
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoValidator pedidoValidator;
    // Cliente para interagir com o serviço de banco externo
    private final ServicoBancoClient servicoBancoClient;

    /**
     * Ao finalizar a transação o pedido e seus itens serão salvos no banco de dados
     * tambem serve para não usar pedidoRepository.save(pedido) duas vezes depois de
     * pedido.setIdPagamento(pagamentoId)
     * Tudo que fizer dentro do método será persistido no final da execução do
     * método
     */
    @Transactional
    public Pedido criar(Pedido pedido) {
        // Validar o pedido antes de salvar
        validarPedido(pedido);
        percistenciaDadosPedido(pedido);
        enviarSolicitacaoPagamento(pedido);
        return pedido;
    }

    private void validarPedido(Pedido pedido) {
        pedidoValidator.validar(pedido);
    }

    private void percistenciaDadosPedido(@NonNull Pedido pedido) {
        // Criar o pedido principal
        pedidoRepository.save(pedido);
        // Valida se existem itens no pedido
        var itens = pedido.getItens();
        if (itens != null && !itens.isEmpty()) {
            // Criar e associar os itens
            itemPedidoRepository.saveAll(itens);
        }
    }

    // Solicitar pagamento ao serviço de banco e associar o ID de pagamento ao
    private void enviarSolicitacaoPagamento(Pedido pedido) {
        var pagamentoId = servicoBancoClient.solicitarPagamento(pedido);
        pedido.setIdPagamento(pagamentoId);
    }

    // Notação serve para suprimir avisos de nullabilidade
    @SuppressWarnings("null")
    public Optional<Pedido> selecionarPorId(Long idpedido) {
        return pedidoRepository.findById(idpedido);
    }

    public void processarCallbackPagamento(
            Long pedidoId, String idPagamento, Boolean status, String observacoes) {

        var infoPedido = pedidoRepository.findByIdpedidoAndIdPagamento(pedidoId, idPagamento);

        if (infoPedido.isEmpty()) {
            var mensagem = String.format("Pedido com ID %d e pagamento %s não encontrado", pedidoId, idPagamento);
            log.error(mensagem);
            return;
        }
        
        if (infoPedido.isPresent()) {
            var pedidoEncontrado = infoPedido.get();
            if (status) {
                pedidoEncontrado.setStatus(StatusPedido.PAGAMENTO_APROVADO);
            } else {
                pedidoEncontrado.setStatus(StatusPedido.ERRO_PAGAMENTO);
            }
            pedidoEncontrado.setObservacoes(observacoes);
            pedidoRepository.save(pedidoEncontrado);
        }
    }
}
