package com.api.consultorio.controller;

import com.api.consultorio.dto.PacienteDto;
import com.api.consultorio.dto.PacienteResponseDto;
import com.api.consultorio.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping()
    public ResponseEntity<List<?>> getPacientes() {
        return ResponseEntity.ok(pacienteService.getPacientes());
    }

    // No funcionan las validaciones !!
    @PostMapping
    ResponseEntity<?> createPaciente(@RequestBody @Valid PacienteDto pacienteDto) {
        return ResponseEntity.ok(pacienteService.createPaciente(pacienteDto));
    }

}
