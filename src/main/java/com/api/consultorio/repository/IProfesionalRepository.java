package com.api.consultorio.repository;

import com.api.consultorio.model.ProfesionalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProfesionalRepository extends JpaRepository<ProfesionalModel, Integer> {
    List<ProfesionalModel> findByEspecialidadId(Integer id);
}
