package com.ufrn.lojagamesretropw.repository;

import com.ufrn.lojagamesretropw.domain.DomainCarrinho;
import com.ufrn.lojagamesretropw.domain.DomainJogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<DomainJogo, Long> {

}

