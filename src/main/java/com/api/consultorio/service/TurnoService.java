package com.api.consultorio.service;

import com.api.consultorio.dto.*;
import com.api.consultorio.exceptions.ResourceNotFoundException;
import com.api.consultorio.model.ConsultorioModel;
import com.api.consultorio.model.PacienteModel;
import com.api.consultorio.model.ProfesionalModel;
import com.api.consultorio.model.TurnoModel;
import com.api.consultorio.repository.ITurnoRepository;
import com.api.consultorio.validator.TurnoValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;
    @Autowired
    private ProfesionalService profesionalService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private ConsultorioService consultorioService;
    @Autowired
    private EspecialidadService especialidadService;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TurnoValidator turnoValidator;

    public List<TurnoResponseDto> getTurnos() {
        List<TurnoModel> turnoModelList = turnoRepository.findAll();
        return mapearListaTurnoModelADto(turnoModelList);

    }

    public TurnoResponseDto createTurno(TurnoDto turno) {
        LocalTime horaTruncada = truncarHora(turno.getHora());
        turno.setHora(horaTruncada);
        // turnoValidator.validarHorario(turno.getFechaHora());
        turnoValidator.validarDisponibilidadPaciente(turno.getPacienteId(), turno.getFecha(), horaTruncada);
        turnoValidator.validarDisponibilidadProfesional(turno.getProfesionalId(), turno.getFecha(), horaTruncada);
        turnoValidator.validarDisponibilidadConsultorio(turno.getProfesionalId(), turno.getFecha(), horaTruncada);

        TurnoModel turnoModel = prepareTurnoModel(turno);

        turnoRepository.save(turnoModel);

        return modelMapper.map(turnoModel, TurnoResponseDto.class);
    }

    public List<TurnoResponseDto> getTurnosByEspecialidadId(Integer id) {
        List<TurnoModel> turnoModelList = turnoRepository.findByProfesionalEspecialidadId(id);

        return mapearListaTurnoModelADto(turnoModelList);


    }


    public List<TurnoResponseDto> getTurnosByProfesionalId(Integer id) {
        List<TurnoModel> turnoModelList = turnoRepository.findByProfesionalId(id);

        return mapearListaTurnoModelADto(turnoModelList);


    }

    public List<TurnoResponseDto> getTurnosByPacienteId(Integer id) {
        if (!pacienteService.existsPacienteById(id)) throw new ResourceNotFoundException("paciente");

        List<TurnoModel> turnoModelList = turnoRepository.findByPacienteId(id);
        return mapearListaTurnoModelADto(turnoModelList);


    }

    public TurnoModel saveTurno(TurnoModel turno) {
        return turnoRepository.save(turno);
    }

    public void deleteTurnoById(Integer id) {
        turnoRepository.deleteById(id);
    }


    public TurnoResponseDto cancelTurno(Integer id) {
        TurnoModel turnoModel = turnoRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("turno", "id", id));

        turnoValidator.validarModificarTurno(turnoModel);

        turnoModel.setEstado(false);
        turnoRepository.save(turnoModel);
        return modelMapper.map(turnoModel, TurnoResponseDto.class);


    }


    public TurnoResponseDto getTurnoById(Integer id) {
        TurnoModel turnoModel = turnoRepository.findById(id).orElse(null);
        return modelMapper.map(turnoModel, TurnoResponseDto.class);


    }


    public List<TurnoResponseDto> mapearListaTurnoModelADto(List<TurnoModel> turnoModelList) {
        if (turnoModelList.isEmpty()) {
            throw new ResourceNotFoundException("turnos");
        }
        return turnoModelList.stream()
                .map(turnoModel -> modelMapper.map(turnoModel, TurnoResponseDto.class))
                .collect(Collectors.toList());
    }

    public TurnoModel prepareTurnoModel(TurnoDto turno) {

        ProfesionalModel profesional = modelMapper.map(profesionalService.getProfesionalById(turno.getProfesionalId()), ProfesionalModel.class);
        PacienteModel paciente = modelMapper.map(pacienteService.getPacienteById(turno.getPacienteId()), PacienteModel.class);
        ConsultorioModel consultorio = modelMapper.map(consultorioService.getConsultorioById(turno.getConsultorioId()), ConsultorioModel.class);


        return new TurnoModel(turno.getFecha(), turno.getHora(), profesional, paciente, consultorio);
    }

    public LocalTime truncarHora(LocalTime hora) {
        if (hora.getMinute() > 0 || hora.getSecond() > 0) {
            return hora.withMinute(0).withSecond(0).plusHours(1);
        }
        return hora.withMinute(0).withSecond(0);
    }


}
