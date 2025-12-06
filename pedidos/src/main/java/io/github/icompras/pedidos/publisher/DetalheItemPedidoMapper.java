package io.github.icompras.pedidos.publisher;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import io.github.icompras.pedidos.model.ItemPedido;
import io.github.icompras.pedidos.publisher.representarion.DetalheItemPedidoRepresentation;

@Mapper(componentModel = "spring")
public interface DetalheItemPedidoMapper {
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    @Mapping(source = "idProduto", target = "produtoId")
    @Mapping(source = "quantidade", target = "quantidade")
    @Mapping(source = "valor", target = "precoUnitario")
    DetalheItemPedidoRepresentation map(ItemPedido item);
}
