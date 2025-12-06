package io.github.icompras.pedidos.controller.dto;

public record AdicionarNovoPagamentoDTO(Long pedidoId, String detalhesPagamento, String metodoPagamento) {

}
