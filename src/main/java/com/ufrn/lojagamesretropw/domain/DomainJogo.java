package com.ufrn.lojagamesretropw.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "Jogo")
@Data
public class DomainJogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeJogo;
    private String genero;
    private int classificacao;
    private BigDecimal preco;
    private int estoque;
    private String tipoMidia;
}
