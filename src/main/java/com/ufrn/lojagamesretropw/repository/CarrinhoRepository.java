package com.ufrn.lojagamesretropw.repository;

import com.ufrn.lojagamesretropw.domain.DomainCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<DomainCarrinho, Long> {
}