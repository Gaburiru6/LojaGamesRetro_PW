package com.ufrn.lojagamesretropw.config;

import com.ufrn.lojagamesretropw.domain.DomainUsuario;
import com.ufrn.lojagamesretropw.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Verifica se o usuário 'admin' já existe para não criar duplicatas
            if (usuarioRepository.findByUsername("admin").isEmpty()) {
                DomainUsuario admin = new DomainUsuario();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin"));
                admin.setRoles("ROLE_ADMIN,ROLE_USER");
                usuarioRepository.save(admin);
            }

            // Verifica se o usuário 'user' já existe
            if (usuarioRepository.findByUsername("user").isEmpty()) {
                DomainUsuario user = new DomainUsuario();
                user.setUsername("user");
                user.setPassword(passwordEncoder.encode("password"));
                user.setRoles("ROLE_USER");
                usuarioRepository.save(user);
            }
        };
    }
}