package io.github.cursodsousa.icompras.pedidos.controller.dto;

import java.math.BigDecimal;

// DTO de ItemPedido, usado para transferir dados de itens em um pedido
public record ItemPedidoDTO(
        Long produtoId, Integer quantidade, BigDecimal precoUnitario) {
}
