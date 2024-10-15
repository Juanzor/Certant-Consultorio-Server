package com.api.consultorio.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDto {

    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]*$", message = "El nombre solo puede contener letras y espacios")
    @Size(min = 2, max = 30, message = "El nombre debe tener al menos entre 2 y 30 caracteres")
    @NotEmpty(message = "Ingresa un nombre")
    private String nombre;

    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]*$", message = "El apellido solo puede contener letras y espacios")
    @Size(min = 2, max = 30, message = "El apellido debe tener al menos entre 2 y 30 caracteres")
    @NotEmpty(message = "Ingresa un apellido ")
    private String apellido;


    @NotNull(message = "Ingresa un DNI")
    private Integer dni;


}
