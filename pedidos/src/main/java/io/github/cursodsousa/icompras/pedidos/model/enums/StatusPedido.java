package io.github.cursodsousa.icompras.pedidos.model.enums;

public enum StatusPedido {
    // Não mudar a ordem dos itens, pois o EnumType.ORDINAL depende disso
    AGUARDANDO_PAGAMENTO,   // 0
    PAGAMENTO_APROVADO,     // 1
    EM_PREPARACAO,          // 2
    ENVIADO,                // 3
    FINALIZADO,             // 4
    CANCELADO,              // 5
    REEMBOLSO               // 6
}
