package com.example.Consultorio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Dentista {

    private Integer id;
    private String nome;
    private String email;
    private Integer numMatricula;
    private String atendeConvenio;

}
