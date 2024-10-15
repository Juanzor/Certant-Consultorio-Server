package com.api.consultorio.controller;

import com.api.consultorio.dto.TurnoDto;
import com.api.consultorio.dto.TurnoResponseDto;
import com.api.consultorio.exceptions.ResourceNotFoundException;
import com.api.consultorio.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;
    private ProfesionalService profesionalService;
    private PacienteService pacienteService;
    private ConsultorioService consultorioService;
    private EspecialidadService especialidadService;


    @GetMapping()
    public ResponseEntity<List<TurnoResponseDto>> getTurnos() {

        List<TurnoResponseDto> turnoResponseDtos = turnoService.getTurnos();


        return ResponseEntity.ok(turnoResponseDtos);

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TurnoResponseDto> getTurnoById(@PathVariable Integer id) {
        TurnoResponseDto turno = turnoService.getTurnoById(id);

        if (turno == null) {
            throw new ResourceNotFoundException("Turno", "id", id);
        }
        return ResponseEntity.ok(turno);

    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<List<TurnoResponseDto>> getTurnosByPacienteId(@PathVariable Integer id) {
        List<TurnoResponseDto> turno = turnoService.getTurnosByPacienteId(id);
        return ResponseEntity.ok(turno);

    }


    @GetMapping("/especialidad/{id}")
    public ResponseEntity<List<TurnoResponseDto>> getTurnosByEspecialidadId(@PathVariable Integer id) {
        List<TurnoResponseDto> turno = turnoService.getTurnosByEspecialidadId(id);
        return ResponseEntity.ok(turno);
    }

    @GetMapping("/profesional/{id}")
    public ResponseEntity<List<TurnoResponseDto>> getTurnosByProfesionalId(@PathVariable Integer id) {
        List<TurnoResponseDto> turno = turnoService.getTurnosByProfesionalId(id);
        return ResponseEntity.ok(turno);
    }

    @PostMapping()
    public ResponseEntity<?> createTurno(@RequestBody TurnoDto turnoDto) {

        TurnoResponseDto turnoResponseDto = turnoService.createTurno(turnoDto);
        return ResponseEntity.ok(turnoResponseDto);


    }

    @PutMapping("/cancelar/{id}")
    public ResponseEntity<?> cancelarTurno(@PathVariable Integer id) {
        TurnoResponseDto turnoCancelado = turnoService.cancelTurno(id);
        return ResponseEntity.ok(turnoCancelado);


    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteTurnoById(@PathVariable Integer id) {
        TurnoResponseDto turno = turnoService.getTurnoById(id);
        if (turno == null) {
            throw new ResourceNotFoundException("Turno");
        }
        turnoService.deleteTurnoById(id);
        return new ResponseEntity<>(turno, HttpStatus.NO_CONTENT);


    }


}
