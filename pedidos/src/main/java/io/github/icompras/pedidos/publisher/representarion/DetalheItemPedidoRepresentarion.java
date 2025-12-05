package io.github.icompras.pedidos.publisher.representarion;

import java.math.BigDecimal;

public record DetalheItemPedidoRepresentarion(
        Long produtoId, Integer quantidade, BigDecimal precoUnitario) {
            
            public BigDecimal getTotal() {
                return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
            }
}
