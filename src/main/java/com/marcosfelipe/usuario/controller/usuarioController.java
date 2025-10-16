package com.marcosfelipe.usuario.controller;


import com.marcosfelipe.usuario.business.UsuarioService;
import com.marcosfelipe.usuario.business.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class usuarioController {

    @PostMapping
    public ResponseEntity<UsuarioDTO>salvarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return ResponseEntity.ok(UsuarioService.salvaUsuario(usuarioDTO));
    }

}
