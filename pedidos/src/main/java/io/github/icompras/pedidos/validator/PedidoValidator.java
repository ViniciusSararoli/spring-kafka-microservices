package io.github.icompras.pedidos.validator;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import io.github.icompras.pedidos.client.ProdutosClient;
import io.github.icompras.pedidos.client.representation.ProdutosRepresentarion;
import io.github.icompras.pedidos.model.Pedido;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PedidoValidator {

    private final ProdutosClient produtosClient;

    public void validar(Pedido pedido) {
        List<Long> idsProdutos = pedido.getItens()
                .stream().map(i -> i.getIdProduto()).toList();
        idsProdutos.forEach(idProduto -> {
            // Chama o serviço de produtos para validar se o produto existe
            ResponseEntity<ProdutosRepresentarion> response = produtosClient.obterDados(idProduto);
            ProdutosRepresentarion produto = response.getBody();
            if (produto == null) {
                throw new IllegalArgumentException("Produto com ID " + idProduto + " não existe.");
            }
        });
    }
}
