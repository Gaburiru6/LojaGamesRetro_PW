package com.ufrn.lojagamesretropw.repository;

import com.ufrn.lojagamesretropw.domain.DomainCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; //teste de importação, pode ser hibernate caso este não funcione
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<DomainCliente, Long> {
    Optional<DomainCliente> findByEmail(String email);
    List<DomainCliente> findByNomeContainingIgnoreCase(String nome);
}
