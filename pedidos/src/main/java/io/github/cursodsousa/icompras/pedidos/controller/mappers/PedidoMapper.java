package io.github.cursodsousa.icompras.pedidos.controller.mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import io.github.cursodsousa.icompras.pedidos.controller.dto.ItemPedidoDTO;
import io.github.cursodsousa.icompras.pedidos.controller.dto.NovoPedidoDTO;
import io.github.cursodsousa.icompras.pedidos.model.ItemPedido;
import io.github.cursodsousa.icompras.pedidos.model.Pedido;
import io.github.cursodsousa.icompras.pedidos.model.enums.StatusPedido;

@Mapper(componentModel = "spring", imports = { LocalDateTime.class, StatusPedido.class,
        BigDecimal.class }, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PedidoMapper {

    ItemPedidoMapper ITEM_PEDIDO_MAPPER = Mappers.getMapper(ItemPedidoMapper.class);

    @Mapping(source = "clienteId", target = "idCliente")
    // @Mapping(target = "dia", expression = "java(LocalDateTime.now())")
    // @Mapping(target = "status", expression = "java(StatusPedido.PENDENTE)")
    // @Mapping(target = "total", expression = "java(BigDecimal.ZERO)")
    @Mapping(target = "itens", source = "itens", qualifiedByName = "itemPedidoListToEntityList")
    // Não precisa mapear, pois os campos são iguais do DadosPagamentoDTO com o
    // DaadosPagamento
    Pedido map(NovoPedidoDTO novoPedidoDTO);

    @Named("itemPedidoListToEntityList")
    default List<ItemPedido> itemPedidoListToEntityList(List<ItemPedidoDTO> dtos) {
        return dtos.stream()
                .map(ITEM_PEDIDO_MAPPER::map)
                .toList();
    }

    @AfterMapping
    default void afterMapping(@MappingTarget Pedido pedido) {
        // Método para qualquer lógica adicional após o mapeamento, se necessário
        pedido.setDia(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);

        var total = calcularTotalPedido(pedido);

        pedido.setTotal(total);
    }

    private static BigDecimal calcularTotalPedido(Pedido pedido) {
        return pedido.getItens().stream()
                .map(item -> item.getValor().multiply(BigDecimal.valueOf(item.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        // Utiliozar o reduce para somar os valores dos itens
        // O método add de BigDecimal é usado para somar os valores
    }
}
