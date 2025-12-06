package io.github.icompras.pedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.icompras.pedidos.model.ItemPedido;
import io.github.icompras.pedidos.model.Pedido;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
    // Varificar se 'Pedido pedido' está igual dentro do método ItemPedido.java
    List<ItemPedido> findByPedido(Pedido pedido);
    
}
