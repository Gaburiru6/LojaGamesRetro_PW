package com.ufrn.lojagamesretropw.services;

import com.ufrn.lojagamesretropw.domain.DomainJogo;
import com.ufrn.lojagamesretropw.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {
    private final JogoRepository jogoRepository;
    @Autowired
    public JogoService(JogoRepository jogoRepository){
        this.jogoRepository = jogoRepository;
    }
    public List<DomainJogo> findAll() {
        return jogoRepository.findAll();
    }

    public  Optional<DomainJogo> findById(Long id) {
        return jogoRepository.findById(id);
    }

    public void save(DomainJogo jogo) {
        jogoRepository.save(jogo);
       // System.out.println(jogo);
    }

    public void deleteById(Long id) {
        jogoRepository.deleteById(id);
    }
}
