package io.github.icompras.pedidos.controller.dto;

public record RecebimentoCallBackDTO(
        Long pedidoId, String idPagamento, Boolean status, String observacoes) {

}
