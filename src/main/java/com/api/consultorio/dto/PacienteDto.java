package com.api.consultorio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDto {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer dni;


}
