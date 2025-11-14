package io.github.cursodsousa.icompras.pedidos.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.cursodsousa.icompras.pedidos.client.ServicoBancoClient;
import io.github.cursodsousa.icompras.pedidos.model.Pedido;
import io.github.cursodsousa.icompras.pedidos.model.enums.StatusPedido;
import io.github.cursodsousa.icompras.pedidos.repository.ItemPedidoRepository;
import io.github.cursodsousa.icompras.pedidos.repository.PedidoRepository;
import io.github.cursodsousa.icompras.pedidos.validator.PedidoValidator;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
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
        pedido.setStatus(StatusPedido.PAGAMENTO_APROVADO); // Atualiza o status para o próximo estágio
    }

    // Notação serve para suprimir avisos de nullabilidade
    @SuppressWarnings("null")
    public Optional<Pedido> selecionarPorId(Long idpedido) {
        return pedidoRepository.findById(idpedido);
    }
}
