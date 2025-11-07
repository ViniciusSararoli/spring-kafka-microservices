package io.github.cursodsousa.icompras.pedidos.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import io.github.cursodsousa.icompras.pedidos.model.enums.StatusPedido;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
    private StatusPedido status;

    @Column(name = "total", nullable = false, precision = 16, scale = 2)
    private BigDecimal total;

    @Column(name = "url_nf", nullable = true)
    private String urlNotaFiscal;

    @Column(name = "codigo_rastreio", nullable = true, length = 300)
    private String codigoRastreio;

    @Transient // Indica que este campo não será persistido no banco de dados
    private DadosPagamento dadosPagamento;

    @OneToMany(mappedBy = "idPedido") //   Indica o relacionamento com ItemPedido
    private List<ItemPedido> itens;
}
