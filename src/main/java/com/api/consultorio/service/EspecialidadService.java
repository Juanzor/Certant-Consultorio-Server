package com.api.consultorio.service;

import com.api.consultorio.dto.EspecialidadDto;
import com.api.consultorio.exceptions.ResourceNotFoundException;
import com.api.consultorio.model.EspecialidadModel;
import com.api.consultorio.repository.IEspecialidadRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EspecialidadService {

    @Autowired
    private IEspecialidadRepository especialidadRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<EspecialidadDto> getEspecialidades() {
        List<EspecialidadModel> especialidadesList = especialidadRepository.findAll();

        return especialidadesList.stream().map(especialidadModel -> modelMapper.map(especialidadModel, EspecialidadDto.class)).collect(Collectors.toList());

    }



    public EspecialidadDto getEspecialidadById(Integer id) {
        EspecialidadModel especialidadModel = especialidadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Especialidad no encontrada"));

        return modelMapper.map(especialidadModel, EspecialidadDto.class);


    }

}
