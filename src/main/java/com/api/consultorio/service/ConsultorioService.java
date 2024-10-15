package com.api.consultorio.service;

import com.api.consultorio.dto.ConsultorioDto;
import com.api.consultorio.exceptions.ResourceNotFoundException;
import com.api.consultorio.model.ConsultorioModel;
import com.api.consultorio.repository.IConsultorioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultorioService {

    @Autowired
    IConsultorioRepository consultorioRepository;
    @Autowired
    private ModelMapper modelMapper;


    public ConsultorioDto getConsultorioById(Integer id) {

        ConsultorioModel consultorioModel = consultorioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Consultorio no encontrado"));
        return modelMapper.map(consultorioModel, ConsultorioDto.class);
    }


    public List<ConsultorioDto> getConsultorios() {
        List<ConsultorioModel> pacientes = consultorioRepository.findAll();
        if (pacientes.isEmpty()) {
            throw new ResourceNotFoundException("consultorios");
        }
        return pacientes.stream()
                .map(consultorioModel -> modelMapper.map(consultorioModel, ConsultorioDto.class))
                .collect(Collectors.toList());

    }
}
