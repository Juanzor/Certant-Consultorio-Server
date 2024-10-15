package com.api.consultorio.service;

import com.api.consultorio.dto.ProfesionalDto;
import com.api.consultorio.exceptions.ResourceNotFoundException;
import com.api.consultorio.model.ProfesionalModel;
import com.api.consultorio.repository.IProfesionalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ProfesionalService {

    @Autowired
    private IProfesionalRepository profesionalRepository;
    @Autowired
    private ModelMapper modelMapper;

    public ProfesionalDto getProfesionalById(Integer id) {

        ProfesionalModel profesionalModel = profesionalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Especialidad no encontrada"));
        return modelMapper.map(profesionalModel, ProfesionalDto.class);

    }


    public List<ProfesionalDto> getProfesionalesByEspecialidad(Integer id) {
        List<ProfesionalModel> profesionalList = profesionalRepository.findByEspecialidadId(id);

        return profesionalList.stream()
                .map(profesionalModel -> modelMapper.map(profesionalModel, ProfesionalDto.class))
                .collect(Collectors.toList());

    }

}
