package io.github.icompras.pedidos.client;

import java.util.UUID;

import org.springframework.stereotype.Component;

import io.github.icompras.pedidos.model.Pedido;
import lombok.extern.slf4j.Slf4j;

@Component
// Libera um logger para a classe
@Slf4j
public class ServicoBancoClient {
    
    public String solicitarPagamento(Pedido pedido) {
        log.info("Solicitando pagamento para o pedido ID: {}", pedido.getIdpedido());
        // Lógica para interagir com o serviço de banco e solicitar pagamento
        return UUID.randomUUID().toString();
    }
}
