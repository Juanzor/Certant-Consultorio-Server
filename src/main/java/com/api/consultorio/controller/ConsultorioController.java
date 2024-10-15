package com.api.consultorio.controller;

import com.api.consultorio.service.ConsultorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ConsultorioController {

    @Autowired
    private ConsultorioService consultorioService;

    @GetMapping("/consultorios")
    public ResponseEntity<List<?>> getConsultorios() {
        return ResponseEntity.ok(consultorioService.getConsultorios());
    }
}
