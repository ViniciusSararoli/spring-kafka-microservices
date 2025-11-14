package io.github.cursodsousa.icompras.pedidos.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.cursodsousa.icompras.pedidos.model.Pedido;
import io.github.cursodsousa.icompras.pedidos.repository.ItemPedidoRepository;
import io.github.cursodsousa.icompras.pedidos.repository.PedidoRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;
    // private final PedidoValidator pedidoValidator;

    @Transactional
    public Pedido criar(@NonNull Pedido pedido) {
        // Criar o pedido principal
        pedidoRepository.save(pedido);
        var itens = pedido.getItens();
        if (itens != null && !itens.isEmpty()) {
            // Criar e associar os itens
            itemPedidoRepository.saveAll(itens);
        }
        return pedido;
    }
}
