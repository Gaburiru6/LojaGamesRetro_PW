package com.ufrn.lojagamesretropw.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Venda")
@Data
public class DomainVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Produto;
    private BigDecimal preco;
    private String cliente;
    private String descricao;
    private LocalDate dataVenda;
    private String formadepagamento;
}