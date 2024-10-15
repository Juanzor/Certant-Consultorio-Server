package com.api.consultorio.repository;

import com.api.consultorio.model.TurnoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ITurnoRepository extends JpaRepository<TurnoModel, Integer> {

    List<TurnoModel> findByProfesionalEspecialidadId(Integer id);

    List<TurnoModel> findByPacienteId(Integer id);


    List<TurnoModel> findByProfesionalId(Integer id);

    boolean existsByPacienteIdAndFechaAndHoraAndEstado(Integer pacienteId, LocalDate fecha, LocalTime hora, Boolean estado);

    boolean existsByProfesionalIdAndFechaAndHoraAndEstado(Integer profesionalId, LocalDate fecha, LocalTime hora,Boolean estado);

    boolean existsByConsultorioIdAndFechaAndHoraAndEstado(Integer consultorioId, LocalDate fecha, LocalTime hora, Boolean estado);


}
