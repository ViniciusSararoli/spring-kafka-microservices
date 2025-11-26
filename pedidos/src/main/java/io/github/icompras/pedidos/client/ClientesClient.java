package io.github.icompras.pedidos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.icompras.pedidos.client.representation.ClientesRepresentation;

@FeignClient(name = "clientes-client", url = "${icompraspedidos.client.clientes.url}")
public interface ClientesClient {
    
    @GetMapping("/clientes/{idcliente}")
    public ResponseEntity<ClientesRepresentation> obterDados(@PathVariable("idcliente") Long idcliente);

}
