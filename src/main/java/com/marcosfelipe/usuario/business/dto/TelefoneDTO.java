package com.marcosfelipe.usuario.business.dto;


import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO {

    private String numero;
    private String ddd;

    public static Snippet builder() {
    }
}
