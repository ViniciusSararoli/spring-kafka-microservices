package io.github.cursodsousa.icompras.pedidos.validator;

import org.springframework.stereotype.Component;

import io.github.cursodsousa.icompras.pedidos.controller.dto.ItemPedidoDTO;
import io.github.cursodsousa.icompras.pedidos.controller.dto.NovoPedidoDTO;
import io.github.cursodsousa.icompras.pedidos.model.Pedido;

@Component
public class PedidoValidator {
    
    public void validar(NovoPedidoDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo");
        }

        if (dto.clienteId() == null || dto.clienteId() <= 0) {
            throw new IllegalArgumentException("ID do cliente inválido");
        }

        if (dto.itens() == null || dto.itens().isEmpty()) {
            throw new IllegalArgumentException("Pedido deve ter pelo menos um item");
        }

        for (ItemPedidoDTO item : dto.itens()) {
            if (item.produtoId() == null || item.produtoId() <= 0) {
                throw new IllegalArgumentException("ID do produto inválido");
            }
            if (item.quantidade() == null || item.quantidade() <= 0) {
                throw new IllegalArgumentException("Quantidade deve ser maior que zero");
            }
            if (item.precoUnitario() == null || item.precoUnitario().compareTo(java.math.BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Preço unitário deve ser maior que zero");
            }
        }
    }

    @Deprecated
    public void validate(Pedido pedido) {
        // Método mantido para compatibilidade, mas deve ser removido após migração
        throw new UnsupportedOperationException("Método obsoleto. Use validar(NovoPedidoDTO)");
    }
}
