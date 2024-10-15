package com.api.consultorio.controller;

import com.api.consultorio.dto.EspecialidadDto;
import com.api.consultorio.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/especialidades")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping()
    public ResponseEntity<List<EspecialidadDto>> getEspecialidades() {
        return ResponseEntity.ok(especialidadService.getEspecialidades());
    }
}
