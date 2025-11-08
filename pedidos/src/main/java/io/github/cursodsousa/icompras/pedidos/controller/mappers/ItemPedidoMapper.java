package io.github.cursodsousa.icompras.pedidos.controller.mappers;

import io.github.cursodsousa.icompras.pedidos.controller.dto.ItemPedidoDTO;
import io.github.cursodsousa.icompras.pedidos.model.ItemPedido;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {

    @Mapping(source = "produtoId", target = "idProduto")
    @Mapping(source = "precoUnitario", target = "valor")
    ItemPedido map(ItemPedidoDTO dto);
}
