package com.api.consultorio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profesional")
public class ProfesionalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesional_id")
    private Integer id;

    private String nombre;

    private String apellido;
    private Integer dni;


    @ManyToOne
    @JoinColumn(name = "especialidad_id", referencedColumnName = "especialidad_id")
    private EspecialidadModel especialidad;


    @OneToMany(mappedBy = "profesional")
    @JsonIgnore
    private List<TurnoModel> turnos;


}
