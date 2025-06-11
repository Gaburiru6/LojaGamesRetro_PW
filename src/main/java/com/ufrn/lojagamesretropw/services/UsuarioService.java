package com.ufrn.lojagamesretropw.services;

import com.ufrn.lojagamesretropw.domain.DomainUsuario;
import com.ufrn.lojagamesretropw.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void cadastrar(DomainUsuario usuario) throws Exception {
        // Verifica se o username já existe no banco
        if (usuarioRepository.findByUsername(usuario.getUsername()).isPresent()) {
            throw new Exception("Nome de usuário já existe.");
        }

        // Codifica a senha antes de salvar
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        // Define o papel padrão para novos usuários
        usuario.setRoles("ROLE_USER");

        usuarioRepository.save(usuario);
    }
}