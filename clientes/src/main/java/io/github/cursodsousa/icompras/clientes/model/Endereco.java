package io.github.cursodsousa.icompras.clientes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "endereco")
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idendereco;

    @Column(name = "cep", nullable = false, length = 8)
    private String cep;

    @Column(name = "logradouro", nullable = true, length = 200)
    private String logradouro;

    @Column(name = "numero", nullable = true, length = 10)
    private String numero;

    @Column(name = "complemento", nullable = true, length = 100)
    private String complemento;

    @Column(name = "cidade", nullable = true, length = 50)
    private String cidade;

    @Column(name = "estado", nullable = true, length = 30)
    private String estado;

    @Column(name = "idcliente", nullable = false)
    private Long idCliente;
}
