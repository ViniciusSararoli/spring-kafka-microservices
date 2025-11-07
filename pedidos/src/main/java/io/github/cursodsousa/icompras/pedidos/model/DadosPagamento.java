package io.github.cursodsousa.icompras.pedidos.model;

import io.github.cursodsousa.icompras.pedidos.model.enums.MetodoPagamento;
import lombok.Data;

@Data
public class DadosPagamento {
    private MetodoPagamento metodoPagamento;
    private String detalhesPagamento;
}
