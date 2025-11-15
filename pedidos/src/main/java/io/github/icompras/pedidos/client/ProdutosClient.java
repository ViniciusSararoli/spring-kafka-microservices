package io.github.icompras.pedidos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.icompras.pedidos.client.representation.ProdutosRepresentarion;

// Usar para declarar o Feign Client de Produtos
@FeignClient(name = "produtos-client", url = "${icompraspedidos.client.produtos.url}")
public interface ProdutosClient {

     @GetMapping("{idproduto}")
    public ResponseEntity<ProdutosRepresentarion> obterDados(@PathVariable("idproduto") Long idproduto);
    
}
