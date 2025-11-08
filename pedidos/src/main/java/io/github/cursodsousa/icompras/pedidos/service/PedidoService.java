package io.github.cursodsousa.icompras.pedidos.service;

import org.springframework.stereotype.Service;
import io.github.cursodsousa.icompras.pedidos.model.Pedido;
import io.github.cursodsousa.icompras.pedidos.repository.ItemPedidoRepository;
import io.github.cursodsousa.icompras.pedidos.repository.PedidoRepository;
// import io.github.cursodsousa.icompras.pedidos.validator.PedidoValidator;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;
    // private final PedidoValidator pedidoValidator;

    // @Transactional
    public Pedido criar(Pedido pedido) {
        // Criar o pedido principal
        pedidoRepository.save(pedido);
        // Criar e associar os itens
        itemPedidoRepository.saveAll(pedido.getItens());
        return pedido;
    }
}
