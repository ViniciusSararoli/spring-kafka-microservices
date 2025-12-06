package io.github.icompras.pedidos.validator;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import feign.FeignException;
import io.github.icompras.pedidos.client.ClientesClient;
import io.github.icompras.pedidos.client.ProdutosClient;
import io.github.icompras.pedidos.client.representation.ClientesRepresentation;
import io.github.icompras.pedidos.client.representation.ProdutosRepresentarion;
import io.github.icompras.pedidos.model.ItemPedido;
import io.github.icompras.pedidos.model.Pedido;
import io.github.icompras.pedidos.model.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class PedidoValidator {

    private final ProdutosClient produtosClient;
    private final ClientesClient clientesClient;

    // Validação geral do pedido
    public void validar(Pedido pedido) {
        // Validação do cliente
        Long idCliente = pedido.getIdCliente();
        validarCliente(idCliente);
        // Validação dos itens do pedido
        pedido.getItens().forEach(this::validarProdutos);
    }

    // Validação de cada item no pedido
    @SuppressWarnings("null")
    private void validarProdutos(ItemPedido item) {
        try {
            // Chama o serviço de produtos para validar se o produto existe
            ResponseEntity<ProdutosRepresentarion> response = produtosClient.obterDados(item.getIdProduto());
            ProdutosRepresentarion produto = response.getBody();
            log.info("Produto {} encontrado: {}", produto.idproduto(), produto.nome());
        } catch (FeignException.NotFound e) {
            throw new ValidationException("itens.idProduto", "Produto " + item.getIdProduto() + " não encontrado");
        }
    }

    // Validação para indentificar se o cliente existe
    @SuppressWarnings("null")
    private void validarCliente(Long idCliente) {
        try {
            // Chama o serviço de clientes para validar se o cliente existe
            ResponseEntity<ClientesRepresentation> response = clientesClient.obterDados(idCliente);
            ClientesRepresentation cliente = response.getBody();
            log.info("Cliente encontrado: {}", cliente.nome());
        } catch (FeignException.NotFound e) {
            throw new ValidationException("idCliente", "Cliente " + idCliente + " não encontrado");
        }
    }
}
