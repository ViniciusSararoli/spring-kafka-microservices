package io.github.icompras.pedidos.client.representation;

import java.math.BigDecimal;

public record ProdutosRepresentarion(Long idProduto, String nome, BigDecimal valor) {
    
}
