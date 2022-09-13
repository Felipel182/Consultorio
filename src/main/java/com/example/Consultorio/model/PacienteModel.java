package com.example.Consultorio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Paciente")
@Getter
@Setter
public class PacienteModel {

    @Id
    @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    private Integer id;

    private String nome, sobrenome, endereco, rg;
    private Date dataAlta;

    public PacienteModel(String nome, String sobrenome, String endereco, String rg, Date dataAlta) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.rg = rg;
        this.dataAlta = dataAlta;
    }

    public PacienteModel() {
    }
}
