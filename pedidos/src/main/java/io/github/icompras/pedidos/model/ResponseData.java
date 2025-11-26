package io.github.icompras.pedidos.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import io.github.icompras.pedidos.model.enums.StatusPedido;

public record ResponseData() {

    // Metodo estatico para criar mensagens de erro
    public static record error(String message, String field, String error) {
    }

    // Metodo estatico para criar mensagens de sucesso
    public static record success(String message, Long pedidoId, BigDecimal total, StatusPedido status, LocalDateTime dia) {
    }
}
