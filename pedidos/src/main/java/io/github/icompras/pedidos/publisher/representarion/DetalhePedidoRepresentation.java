package io.github.icompras.pedidos.publisher.representarion;

import java.math.BigDecimal;

public record DetalhePedidoRepresentation(
    Long pedidoId,
    Long clienteId,
    String nomecliente,
    String cpf_cnpj,
    String logradouro,
    String numero,
    String bairro,
    String email,
    String telefone,
    String status,
    String dia,
    BigDecimal total,
    DetalheItemPedidoRepresentarion[] itens
) {
    
}
