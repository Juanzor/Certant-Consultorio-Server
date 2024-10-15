package com.api.consultorio.repository;

import com.api.consultorio.model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<PacienteModel, Integer> {
}
