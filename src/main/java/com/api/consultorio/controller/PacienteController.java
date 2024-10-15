package com.api.consultorio.controller;

import com.api.consultorio.dto.PacienteDto;
import com.api.consultorio.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping()
    public ResponseEntity<List<?>> getPacientes() {
        return ResponseEntity.ok(pacienteService.getPacientes());
    }

    @PostMapping
    ResponseEntity<PacienteDto> createPaciente(@RequestBody PacienteDto pacienteDto) {
        return ResponseEntity.ok(pacienteService.createPaciente(pacienteDto));
    }

}
