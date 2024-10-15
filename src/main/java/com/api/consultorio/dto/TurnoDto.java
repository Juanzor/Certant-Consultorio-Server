package com.api.consultorio.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@NoArgsConstructor
public class TurnoDto {

    private Integer profesionalId;
    private Integer pacienteId;
    private Integer consultorioId;
    private LocalDate fecha;
    private LocalTime hora;
    private Boolean estado;

    public TurnoDto(LocalDate fecha, LocalTime hora, Integer profesionalId, Integer pacienteId, Integer consultorioId) {
        this.fecha = fecha;
        this.hora = hora;
        this.profesionalId = profesionalId;
        this.pacienteId = pacienteId;
        this.consultorioId = consultorioId;
        this.estado = true;

    }


}
