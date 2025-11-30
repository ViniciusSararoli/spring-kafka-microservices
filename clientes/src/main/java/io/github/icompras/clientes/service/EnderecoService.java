package io.github.icompras.clientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.icompras.clientes.model.Endereco;
import io.github.icompras.clientes.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;

@Service
// Cria um construtor com todo os argumentos obrigatórios
@RequiredArgsConstructor
public class EnderecoService {

    @Autowired
    private final EnderecoRepository repository;

    public Endereco salvar(Endereco endereco) {
        return repository.save(endereco);
    }

    public Optional<Endereco> selecionarPorId(Long idendereco) {
        return repository.findById(idendereco);
    }

    public List<Endereco> buscarPorIdCliente(Long idCliente) {
        return repository.findByIdCliente(idCliente);
    }
}
