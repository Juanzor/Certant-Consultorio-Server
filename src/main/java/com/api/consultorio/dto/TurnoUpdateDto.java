package com.api.consultorio.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnoUpdateDto {
    private LocalDate fecha;
    private LocalTime hora;
    private Integer profesionalId;
    private Integer pacienteId;
    private Integer consultorioId;
    private Boolean estado;
}