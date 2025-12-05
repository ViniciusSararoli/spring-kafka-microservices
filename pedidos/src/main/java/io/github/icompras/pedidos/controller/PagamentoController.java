package io.github.icompras.pedidos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.icompras.pedidos.controller.dto.RecebimentoCallBackDTO;
import io.github.icompras.pedidos.properties.PagamentoProperties;
import io.github.icompras.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;

// Webhook para receber callbacks de pagamento
@RestController
@RequestMapping("/pedido/callback-pagamento")
@RequiredArgsConstructor
public class PagamentoController {
    private final PedidoService pedidoService;
    private final PagamentoProperties pagamentoProperties;

    @PostMapping
    public ResponseEntity<Object> receberCallbackPagamento(
            @RequestBody RecebimentoCallBackDTO recebimentoCallBackDTO,
            @RequestHeader(required = true, name = "api-key") String apiKey) {

        if (!apiKey.equals(pagamentoProperties.getApikey())) {
            return ResponseEntity.status(403).build();
        }

        pedidoService.processarCallbackPagamento(
                recebimentoCallBackDTO.pedidoId(),
                recebimentoCallBackDTO.idPagamento(),
                recebimentoCallBackDTO.status(),
                recebimentoCallBackDTO.observacoes());

        return ResponseEntity.ok().build();
    }
}
