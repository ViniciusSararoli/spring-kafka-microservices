package io.github.icompras.pedidos.controller.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import io.github.icompras.pedidos.controller.dto.ItemPedidoDTO;
import io.github.icompras.pedidos.model.ItemPedido;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    @Mapping(source = "produtoId", target = "idProduto")
    @Mapping(source = "precoUnitario", target = "valor")
    ItemPedido map(ItemPedidoDTO dto);
}
