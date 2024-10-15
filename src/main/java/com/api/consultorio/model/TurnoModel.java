package com.api.consultorio.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "turno")
public class TurnoModel {

    public TurnoModel(LocalDate fecha, LocalTime hora, ProfesionalModel profesional, PacienteModel paciente, ConsultorioModel consultorio) {

        this.fecha = fecha;
        this.hora = hora;
        this.profesional = profesional;
        this.paciente = paciente;
        this.consultorio = consultorio;
        this.estado = true;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "turno_id")
    private Integer id;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora")
    private LocalTime hora;

    private Boolean estado;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profesional_id", referencedColumnName = "profesional_id")
    @JsonManagedReference
    private ProfesionalModel profesional;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paciente_id", referencedColumnName = "paciente_id")
    @JsonManagedReference
    private PacienteModel paciente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "consultorio_id", referencedColumnName = "consultorio_id")
    @JsonManagedReference
    private ConsultorioModel consultorio;



}
