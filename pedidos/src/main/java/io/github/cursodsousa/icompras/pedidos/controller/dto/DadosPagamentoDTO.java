package io.github.cursodsousa.icompras.pedidos.controller.dto;

import io.github.cursodsousa.icompras.pedidos.model.enums.MetodoPagamento;

public record DadosPagamentoDTO(MetodoPagamento metodoPagamento, String detalhesPagamento) {
    
}
