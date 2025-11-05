package io.github.cursodsousa.icompras.clientes.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.cursodsousa.icompras.clientes.model.Endereco;
import io.github.cursodsousa.icompras.clientes.service.EnderecoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("endereco")
public class EnderecoController {
    private final EnderecoService service;

    @PostMapping
    public ResponseEntity<Endereco> salvar(@RequestBody Endereco endereco) {
        service.salvar(endereco);
        return ResponseEntity.ok(endereco);
    }

    @GetMapping("{idendereco}")
    public ResponseEntity<Endereco> obterDados(@PathVariable("idendereco") Long idendereco) {
        return service
                .selecionarPorId(idendereco)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("cliente/{idcliente}")
    public ResponseEntity<List<Endereco>> getByIdCliente(@PathVariable("idcliente") Long idCliente) {
        List<Endereco> enderecos = service.buscarPorIdCliente(idCliente);

        if (enderecos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(enderecos);
    }
}
