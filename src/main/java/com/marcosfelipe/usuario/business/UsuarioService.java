package com.marcosfelipe.usuario.business;

import com.marcosfelipe.usuario.business.converter.UsuarioConverter;
import com.marcosfelipe.usuario.business.dto.UsuarioDTO;
import com.marcosfelipe.usuario.infrastructure.entity.Usuario;
import com.marcosfelipe.usuario.infrastructure.repository.EnderecoRepository;
import com.marcosfelipe.usuario.infrastructure.repository.TelefoneRepository;
import com.marcosfelipe.usuario.infrastructure.repository.UsuarioRepository;
import com.marcosfelipe.usuario.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final EnderecoRepository enderecoRepository;
    private final TelefoneRepository telefoneRepository;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO) {
        emailExiste(usuarioDTO.getEmail());
        usuarioDTO.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(
                usuarioRepository.save(usuario)
        );
    }
}