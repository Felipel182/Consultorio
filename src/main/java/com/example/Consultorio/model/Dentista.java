package com.example.Consultorio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Dentista")
public class Dentista {


    @Id
    @SequenceGenerator(name = "dentista_sequence", sequenceName = "dentista_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    private Integer id;

    private String nome, sobrenome;
    private Integer numMatricula;

    public Dentista(String nome, String sobrenome, Integer numMatricula) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numMatricula = numMatricula;
    }

    public Dentista() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(Integer numMatricula) {
        this.numMatricula = numMatricula;
    }
}
