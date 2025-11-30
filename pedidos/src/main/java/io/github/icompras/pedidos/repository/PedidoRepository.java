package io.github.icompras.pedidos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.icompras.pedidos.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Método para encontrar um pedido pelo seu ID e ID de pagamento, usado na validação do callback de pagamento 'processarCallbackPagamento'
    Optional<Pedido> findByIdpedidoAndIdPagamento(Long idpedido, String idPagamento);
    
}
