package com.example.Consultorio.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Consulta")
@Getter
@Setter
@NoArgsConstructor
public class ConsultaModel {

    @Id
    @SequenceGenerator(name = "consulta_sequence", sequenceName = "consulta_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    private Integer consultaID;

    private Date dataConsulta;
    private Date horaConsulta;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id")
    private PacienteModel pacienteModel;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dentista_id")
    private Dentista dentista;

    public ConsultaModel(Date dataConsulta, Date horaConsulta, PacienteModel pacienteModel, Dentista dentista) {
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.pacienteModel = pacienteModel;
        this.dentista = dentista;
    }
}
