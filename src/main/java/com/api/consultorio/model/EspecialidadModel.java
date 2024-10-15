package com.api.consultorio.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="especialidad")
public class EspecialidadModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="especialidad_id")
    private Integer id;

    private String nombre;


    @OneToMany(mappedBy = "especialidad")
    @JsonIgnore
    private List<ProfesionalModel> profesionales;


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

    public List<ProfesionalModel> getProfesionales() {
        return profesionales;
    }

    public void setProfesionales(List<ProfesionalModel> profesionales) {
        this.profesionales = profesionales;
    }
}
