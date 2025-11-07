package io.github.cursodsousa.icompras.pedidos.controller.mappers;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import io.github.cursodsousa.icompras.pedidos.controller.dto.ItemPedidoDTO;
import io.github.cursodsousa.icompras.pedidos.model.ItemPedido;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {
    
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    @Mapping(source = "produtoId", target = "idProduto")
    @Mapping(source = "precoUnitario", target = "valor")
    @Mapping(target = "idPedido", ignore = true)
    @Mapping(target = "iditem_pedido", ignore = true)
    ItemPedido map(ItemPedidoDTO dto);

    List<ItemPedido> map(List<ItemPedidoDTO> dtos);
}
