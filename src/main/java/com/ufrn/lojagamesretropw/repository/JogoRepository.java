package com.ufrn.lojagamesretropw.repository;

import com.ufrn.lojagamesretropw.domain.DomainJogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<DomainJogo, Long> {
    List<DomainJogo> findByIsDeletedIsNull();

}

