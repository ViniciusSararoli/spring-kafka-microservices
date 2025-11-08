package io.github.cursodsousa.icompras.pedidos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.cursodsousa.icompras.pedidos.controller.dto.NovoPedidoDTO;
import io.github.cursodsousa.icompras.pedidos.controller.mappers.PedidoMapper;
import io.github.cursodsousa.icompras.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;
    private final PedidoMapper pedidoMapper;

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody NovoPedidoDTO novoPedidoDTO) {
        var pedido = pedidoMapper.map(novoPedidoDTO);
        var novoPedido = pedidoService.criar(pedido);
        return ResponseEntity.ok(novoPedido.getIdpedido());
    }
}
