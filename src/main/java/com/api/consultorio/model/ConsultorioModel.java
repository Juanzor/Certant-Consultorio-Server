package com.api.consultorio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "consultorio")
public class ConsultorioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consultorio_id")
    private Integer id;

    private String nombre;

    @OneToMany(mappedBy = "consultorio")
    @JsonIgnore
    private List<TurnoModel> turnos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<TurnoModel> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<TurnoModel> turnos) {
        this.turnos = turnos;
    }
}
