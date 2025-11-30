package io.github.icompras.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.icompras.clientes.model.Clientes;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}
