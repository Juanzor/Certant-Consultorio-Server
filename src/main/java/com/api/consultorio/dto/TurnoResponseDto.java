package com.api.consultorio.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoResponseDto {
    private Integer id;
    private ProfesionalDto profesional;
    private PacienteDto paciente;
    private ConsultorioDto consultorio;
    private Boolean estado;
    private LocalDate fecha;
    private LocalTime hora;


    public TurnoResponseDto(Integer id, ProfesionalDto profesional, PacienteDto paciente, ConsultorioDto consultorio, LocalDate fecha, LocalTime hora, Boolean estado) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.profesional = profesional;
        this.paciente = paciente;
        this.consultorio = consultorio;
        this.estado = estado;
    }

    public TurnoResponseDto() {
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


    public ConsultorioDto getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(ConsultorioDto consultorio) {
        this.consultorio = consultorio;
    }

    public PacienteDto getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDto paciente) {
        this.paciente = paciente;
    }

    public ProfesionalDto getProfesional() {
        return profesional;
    }

    public void setProfesional(ProfesionalDto profesional) {
        this.profesional = profesional;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
