package io.github.icompras.pedidos.publisher.representarion;

import java.math.BigDecimal;
import java.util.List;

public record DetalhePedidoRepresentation(
    Long pedidoId,
    Long clienteId,
    String nomeCliente,
    String cpfCnpj,
    String logradouro,
    String numero,
    String bairro,
    String email,
    String telefone,
    String status,
    String dia,
    BigDecimal total,
    List<DetalheItemPedidoRepresentation> itens
) {
    
}
