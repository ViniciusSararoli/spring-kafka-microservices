package io.github.icompras.pedidos.client.representation;

import java.math.BigDecimal;

// Deve ter os mesmos aributos do modelo de produtos
public record ProdutosRepresentarion(
        Long idproduto, String nome, BigDecimal valor) {

}
