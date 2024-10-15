package com.api.consultorio.repository;
import com.api.consultorio.model.ConsultorioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsultorioRepository extends JpaRepository<ConsultorioModel, Integer> {
}
