package com.api.consultorio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@NoArgsConstructor
@Data
@AllArgsConstructor
public class TurnoResponseDto {
    private Integer id;
    private ProfesionalDto profesional;
    private PacienteResponseDto paciente;
    private ConsultorioDto consultorio;
    private Boolean estado;
    private LocalDate fecha;
    private LocalTime hora;


}
