package com.ufrn.lojagamesretropw.services;

import com.ufrn.lojagamesretropw.domain.DomainJogo;
import com.ufrn.lojagamesretropw.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class JogoService {
    private final JogoRepository jogoRepository;

    @Autowired
    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public List<DomainJogo> findAll() {
        return jogoRepository.findAll();
    }

    public Optional<DomainJogo> findById(Long id) {
        return jogoRepository.findById(id);
    }

    public List<DomainJogo> findAllActive() {
        return jogoRepository.findByIsDeletedIsNull();
    }

    @Transactional
    public void save(DomainJogo jogo) {
        jogoRepository.save(jogo);
        // System.out.println(jogo);
    }

    public void deleteById(Long id) {
        jogoRepository.deleteById(id);
    }

    @Transactional
    public void softDelete(Long id) {
        Optional<DomainJogo> jogoOptional = jogoRepository.findById(id);

        if (jogoOptional.isPresent()) {
            DomainJogo jogo = jogoOptional.get();
            jogo.setIsDeleted(new Date());
            jogoRepository.save(jogo);
        }
    }

    @Transactional
    public void softRestore(Long id) {
        Optional<DomainJogo> jogoOptional = jogoRepository.findById(id);

        if (jogoOptional.isPresent()) {
            DomainJogo jogo = jogoOptional.get();
            jogo.setIsDeleted(null);
            jogoRepository.save(jogo);
        }
    }
}
