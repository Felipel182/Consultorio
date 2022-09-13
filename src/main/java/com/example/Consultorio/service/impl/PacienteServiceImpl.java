package com.example.Consultorio.service.impl;

import com.example.Consultorio.model.PacienteModel;
import com.example.Consultorio.repository.PacienteRepository;
import com.example.Consultorio.service.PacienteService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class PacienteServiceImpl implements PacienteService<PacienteModel> {

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public String salvar(PacienteModel p) throws SQLException {
        if (p != null) {
            pacienteRepository.save(p);
            return "Paciente salvo";
        }
        return "Paciente não encontrado";
    }

    @Override
    public List<PacienteModel> buscarTodos() throws SQLException{
        return pacienteRepository.findAll();
    }

    @Override
    public String excluir(Integer id) throws SQLException{
        if (pacienteRepository.findById(id).isPresent()) {
            pacienteRepository.deleteById(id);
            return "Paciente excluído";
        }
        return "Paciente não encontrado";
    }

    @Override
    public String updatePaciente(PacienteModel p){
        if (p != null && pacienteRepository.findById(p.getId()).isPresent()){
            pacienteRepository.saveAndFlush(p);
            return "Paciente atualizado";
        }
        return "Paciente não encontrado";
    };
}
