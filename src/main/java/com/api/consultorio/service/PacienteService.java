package com.api.consultorio.service;

import com.api.consultorio.dto.PacienteDto;
import com.api.consultorio.dto.PacienteResponseDto;
import com.api.consultorio.exceptions.ResourceNotFoundException;
import com.api.consultorio.model.PacienteModel;
import com.api.consultorio.repository.IPacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<PacienteDto> getPacientes() {
        List<PacienteModel> pacientes = pacienteRepository.findAll();
        if (pacientes.isEmpty()) {
            throw new ResourceNotFoundException("clientes");
        }
        return pacientes.stream()
                .map(pacienteModel -> modelMapper.map(pacienteModel, PacienteDto.class))
                .collect(Collectors.toList());

    }

    public Boolean existsPacienteById(Integer id) {
        return pacienteRepository.existsById(id);
    }

    public PacienteResponseDto getPacienteById(Integer id) {

        PacienteModel pacienteModel = pacienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado"));
        return modelMapper.map(pacienteModel, PacienteResponseDto.class);
    }

    public PacienteResponseDto createPaciente(PacienteDto paciente) {
        PacienteModel pacienteModel = modelMapper.map(paciente, PacienteModel.class);
        pacienteRepository.save(pacienteModel);
        return modelMapper.map(pacienteModel, PacienteResponseDto.class);
    }


}
