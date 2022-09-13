package com.example.Consultorio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Consulta")
public class ConsultaModel {

    @Id
    @SequenceGenerator(name = "consulta_sequence", sequenceName = "consulta_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator")
    private Integer id;

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

    public ConsultaModel() {
    }

    public Integer getId() {
        return id;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Date getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(Date horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public PacienteModel getPacienteModel() {
        return pacienteModel;
    }

    public void setPacienteModel(PacienteModel pacienteModel) {
        this.pacienteModel = pacienteModel;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }
}
