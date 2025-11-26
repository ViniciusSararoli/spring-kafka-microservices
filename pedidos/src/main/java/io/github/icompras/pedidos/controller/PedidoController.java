package io.github.icompras.pedidos.controller;

import io.github.icompras.pedidos.model.ResponseData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.icompras.pedidos.controller.dto.NovoPedidoDTO;
import io.github.icompras.pedidos.controller.mappers.PedidoMapper;
import io.github.icompras.pedidos.model.exception.ValidationException;
import io.github.icompras.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;
    private final PedidoMapper pedidoMapper;

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody NovoPedidoDTO novoPedidoDTO) {
        try {
            var pedido = pedidoMapper.map(novoPedidoDTO);
            var novoPedido = pedidoService.criar(pedido);
            var successResponse = new ResponseData.success("Pedido criado com sucesso", novoPedido.getIdpedido(), novoPedido.getTotal(), novoPedido.getStatus(), novoPedido.getDia());
            return ResponseEntity.ok(successResponse);
        } catch (ValidationException e) {
            var errorResponse = new ResponseData.error("Validation Error", e.getField(), e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @GetMapping("/{idpedido}")
    public ResponseEntity<Object> obterDetalhes(@PathVariable Long idpedido) {
        var dadosPedido = pedidoService.selecionarPorId(idpedido);
        return ResponseEntity.ok(dadosPedido);
    }
}
