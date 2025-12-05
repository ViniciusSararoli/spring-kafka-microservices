package io.github.icompras.pedidos.model;

import io.github.icompras.pedidos.model.enums.MetodoPagamento;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DadosPagamento {
    private MetodoPagamento metodoPagamento;
    private String detalhesPagamento;
}
