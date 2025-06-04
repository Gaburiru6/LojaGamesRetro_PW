package com.ufrn.lojagamesretropw.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Vendedor")
@Data
public class DomainVendedor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String senha;
    private String cracha;
}
