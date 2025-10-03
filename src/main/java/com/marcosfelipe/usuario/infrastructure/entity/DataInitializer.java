package com.marcosfelipe.usuario.infrastructure.entity;

import com.javanauta.usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(UsuarioRepository usuarioRepository) {
        return args -> {
            if (usuarioRepository.count() == 0) { // Verifica se já existem usuários
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                
                com.javanauta.usuario.infrastructure.entity.Usuario admin = new com.javanauta.usuario.infrastructure.entity.Usuario();
                admin.setNome("Administrador");
                admin.setEmail("admin@admin.com");
                admin.setSenha(passwordEncoder.encode("1234"));
                
                com.javanauta.usuario.infrastructure.entity.Usuario usuario = new com.javanauta.usuario.infrastructure.entity.Usuario();
                usuario.setNome("Usuário Comum");
                usuario.setEmail("usuario@email.com");
                usuario.setSenha(passwordEncoder.encode("usuario123$"));
                
                usuarioRepository.save(admin);
                usuarioRepository.save(usuario);
                
                System.out.println("Usuários criados com sucesso!");
            }
        };
    }
}