package io.github.cursodsousa.icompras.pedidos.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pedido")
@Data
@Getter
@Setter
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpedido;

    @Column(name = "idcliente", nullable = false)
    private Long idCliente;

    @Column(name = "dia", nullable = false)
    private LocalDateTime dia;

    @Column(name = "idpagamento", nullable = true)
    private String idPagamento;

    @Column(name = "observacoes", nullable = true)
    private String observacoes;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.ORDINAL) // Usar ordinal para salvar como inteiro no banco de dados
    private Integer status;

    @Column(name = "total", nullable = false, precision = 16, scale = 2)
    private BigDecimal total;

    @Column(name = "url_nf", nullable = true)
    private String urlNotaFiscal;

    @Column(name = "codigo_rastreio", nullable = true, length = 300)
    private String codigoRastreio;
}
