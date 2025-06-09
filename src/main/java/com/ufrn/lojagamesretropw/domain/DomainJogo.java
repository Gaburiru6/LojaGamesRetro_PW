package com.ufrn.lojagamesretropw.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date; // Import necessário

@Entity
@Table(name = "Jogo")
@Data
public class DomainJogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String nomeJogo;

    private String genero;

    private int classificacao;
    @Column(nullable = false)
    private BigDecimal preco;

    private int estoque;

    private String tipoMidia;

    // CAMPOS ADICIONADOS CONFORME A ESPECIFICAÇÃO
    private String imgUrl;
    private Date isDeleted;
}