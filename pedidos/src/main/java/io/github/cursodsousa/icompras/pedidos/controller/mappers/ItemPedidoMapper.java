package io.github.cursodsousa.icompras.pedidos.controller.mappers;

import io.github.cursodsousa.icompras.pedidos.controller.dto.ItemPedidoDTO;
import io.github.cursodsousa.icompras.pedidos.model.ItemPedido;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    @Mapping(source = "produtoId", target = "idProduto")
    @Mapping(source = "precoUnitario", target = "valor")
    ItemPedido map(ItemPedidoDTO dto);
}
