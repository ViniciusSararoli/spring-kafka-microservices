package io.github.icompras.pedidos.controller.dto;

import io.github.icompras.pedidos.model.enums.MetodoPagamento;

public record DadosPagamentoDTO(MetodoPagamento metodoPagamento, String detalhesPagamento) {
    
}
