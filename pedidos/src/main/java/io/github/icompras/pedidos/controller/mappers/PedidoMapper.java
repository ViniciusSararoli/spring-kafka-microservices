package io.github.icompras.pedidos.controller.mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import io.github.icompras.pedidos.controller.dto.NovoPedidoDTO;
import io.github.icompras.pedidos.model.Pedido;
import io.github.icompras.pedidos.model.enums.StatusPedido;

@Mapper(componentModel = "spring", uses = ItemPedidoMapper.class)
public interface PedidoMapper {

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    @Mapping(source = "clienteId", target = "idCliente")
    @Mapping(target = "itens", source = "itens")
    Pedido map(NovoPedidoDTO novoPedidoDTO);

    @AfterMapping
    default void afterMapping(NovoPedidoDTO dto, @MappingTarget Pedido pedido) {
        // Define dia e status inicial
        pedido.setDia(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);

        // Se não houver itens, evita NPE e define total 0
        if (pedido.getItens() == null || pedido.getItens().isEmpty()) {
            pedido.setTotal(BigDecimal.ZERO);
            return;
        }

        // Calcula total e associa o pedido em cada item
        var total = calcularTotalPedido(pedido);
        pedido.setTotal(total);

        pedido.getItens().forEach(item -> item.setPedido(pedido));
    }

    private static BigDecimal calcularTotalPedido(Pedido pedido) {
        return pedido.getItens().stream()
                .map(item -> item.getValor().multiply(BigDecimal.valueOf(item.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        // Utilizar o reduce para somar os valores dos itens
        // O método add de BigDecimal é usado para somar os valores
    }
}
