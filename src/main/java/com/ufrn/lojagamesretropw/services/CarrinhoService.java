package com.ufrn.lojagamesretropw.services;

import com.ufrn.lojagamesretropw.domain.DomainJogo;
import com.ufrn.lojagamesretropw.repository.JogoRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoService {

    private final JogoRepository jogoRepository;

    public CarrinhoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }


    public void adicionarAoCarrinho(Long idJogo, HttpSession session) {
        Optional<DomainJogo> jogoOptional = jogoRepository.findById(idJogo);

        if (jogoOptional.isPresent()) {
            DomainJogo jogo = jogoOptional.get();

            List<DomainJogo> carrinho = getCarrinho(session);

            carrinho.add(jogo);

            session.setAttribute("carrinho", carrinho);
        } else {
            throw new RuntimeException("Jogo não encontrado com o ID: " + idJogo);
        }
    }
    public void removerDoCarrinho(Long idJogo, HttpSession session) {
        List<DomainJogo> carrinho = getCarrinho(session);
        carrinho.removeIf(jogo -> jogo.getId() == idJogo);
        session.setAttribute("carrinho", carrinho);
    }


    public List<DomainJogo> getItensDoCarrinho(HttpSession session) {
        return getCarrinho(session);
    }


    public void limparCarrinho(HttpSession session) {
        session.invalidate();
    }


    private List<DomainJogo> getCarrinho(HttpSession session) {
        List<DomainJogo> carrinho = (List<DomainJogo>) session.getAttribute("carrinho");
        if (carrinho == null) {
            carrinho = new ArrayList<>();
            session.setAttribute("carrinho", carrinho);
        }
        return carrinho;
    }
}