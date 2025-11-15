package io.github.icompras.pedidos.controller.dto;

import java.util.List;

// DTO de NovoPedidoDTO, usado para transferir dados carrinho completo para criação de um novo pedido
public record NovoPedidoDTO(
                Long clienteId, DadosPagamentoDTO dadosPagamento, List<ItemPedidoDTO> itens) {

}
