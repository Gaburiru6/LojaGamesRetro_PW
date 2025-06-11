package com.ufrn.lojagamesretropw.repository;

import com.ufrn.lojagamesretropw.domain.DomainUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<DomainUsuario, Long> {
    // Método para buscar um usuário pelo nome de usuário
    Optional<DomainUsuario> findByUsername(String username);
}