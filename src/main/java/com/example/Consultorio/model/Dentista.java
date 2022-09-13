package com.example.Consultorio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Dentista")
public class Dentista {


    @Id
    @SequenceGenerator(name = "dentista_sequence", sequenceName = "dentista_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    private Integer id;

    private String nome, sobrenome;
    private Integer numMatricula;

}
