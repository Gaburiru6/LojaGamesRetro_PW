package com.ufrn.lojagamesretropw.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "Console")
@Data
public class DomainConsole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int modelo;
    private String marca;
    private String estado;
    private BigDecimal preco;
    private int estoque;
}
