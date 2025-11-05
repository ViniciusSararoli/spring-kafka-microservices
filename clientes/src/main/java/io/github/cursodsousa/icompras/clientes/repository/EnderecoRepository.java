package io.github.cursodsousa.icompras.clientes.repository;

import java.util.List;
// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.cursodsousa.icompras.clientes.model.Endereco;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    // Faz um SELECT * FROM endereco WHERE idcliente = :idcliente
    List<Endereco> findByIdCliente(Long idCliente);

    // Optional<Endereco> finOptionalById(Long idendereco);
}
