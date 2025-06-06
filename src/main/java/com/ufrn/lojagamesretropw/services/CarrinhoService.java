package com.ufrn.lojagamesretropw.services;

import com.ufrn.lojagamesretropw.repository.CarrinhoRepository;
import com.ufrn.lojagamesretropw.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {
    private CarrinhoRepository carrinhoRepository = null;
    @Autowired
    public CarrinhoService(CarrinhoService carrinhoService, ClienteRepository clienteRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }

}
