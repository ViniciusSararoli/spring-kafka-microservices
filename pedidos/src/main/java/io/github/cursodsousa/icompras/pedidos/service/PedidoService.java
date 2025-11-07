package io.github.cursodsousa.icompras.pedidos.service;

//import java.math.BigDecimal;

import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

//import io.github.cursodsousa.icompras.pedidos.controller.dto.ItemPedidoDTO;
import io.github.cursodsousa.icompras.pedidos.controller.dto.NovoPedidoDTO;
//import io.github.cursodsousa.icompras.pedidos.controller.mappers.ItemPedidoMapper;
//import io.github.cursodsousa.icompras.pedidos.controller.mappers.PedidoMapper;
//import io.github.cursodsousa.icompras.pedidos.model.ItemPedido;
import io.github.cursodsousa.icompras.pedidos.model.Pedido;
import io.github.cursodsousa.icompras.pedidos.repository.ItemPedidoRepository;
import io.github.cursodsousa.icompras.pedidos.repository.PedidoRepository;
import io.github.cursodsousa.icompras.pedidos.validator.PedidoValidator;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoValidator pedidoValidator;
    // private final PedidoMapper pedidoMapper;
    // private final ItemPedidoMapper itemPedidoMapper;

    // @Transactional
    public Pedido criar(NovoPedidoDTO dto) {
        // Validar o pedido
        /*
         * pedidoValidator.validar(dto);
         * 
         * // Criar o pedido principal
         * Pedido pedido = pedidoMapper.map(dto);
         * pedido = pedidoRepository.save(pedido);
         * 
         * // Criar e associar os itens
         * BigDecimal total = BigDecimal.ZERO;
         * for (ItemPedidoDTO itemDTO : dto.itens()) {
         * ItemPedido item = itemPedidoMapper.toEntity(itemDTO);
         * item.setIdPedido(pedido.getIdpedido());
         * itemPedidoRepository.save(item);
         * 
         * // Atualizar o total
         * total = total.add(item.getValor().multiply(new
         * BigDecimal(item.getQuantidade())));
         * }
         * 
         * // Atualizar o total do pedido
         * pedido.setTotal(total);
         * return pedidoRepository.save(pedido);
         */
        return null;
    }
}
