package com.api.consultorio.controller;
import com.api.consultorio.dto.ProfesionalDto;
import com.api.consultorio.service.ProfesionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class ProfesionalController {
    @Autowired
    private ProfesionalService profesionalService;

    @GetMapping("/profesional/especialidad/{id}")
    public ResponseEntity<List<ProfesionalDto>> getProfesionalesByEspecialidad(@PathVariable Integer id) {
        return ResponseEntity.ok(profesionalService.getProfesionalesByEspecialidad(id));
    }

}
