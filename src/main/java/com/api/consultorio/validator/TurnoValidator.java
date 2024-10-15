package com.api.consultorio.validator;

import com.api.consultorio.exceptions.BadRequestException;
import com.api.consultorio.exceptions.TurnoConflictException;
import com.api.consultorio.model.TurnoModel;
import com.api.consultorio.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.*;

@Component
public class TurnoValidator {
    @Autowired
    private ITurnoRepository turnoRepository;

    public void validarDisponibilidadProfesional(Integer profesionalId, LocalDate fecha, LocalTime hora) {
        if (turnoRepository.existsByProfesionalIdAndFechaAndHoraAndEstado(profesionalId, fecha, hora, true)) {
            throw new TurnoConflictException("El profesional ya tiene un turno en esa fecha y horario");
        }
    }

    public void validarDisponibilidadPaciente(Integer pacienteId, LocalDate fecha, LocalTime hora) {
        if (turnoRepository.existsByPacienteIdAndFechaAndHoraAndEstado(pacienteId, fecha, hora, true)) {
            throw new TurnoConflictException("El paciente ya tiene un turno en esa fecha y horario");
        }
    }

    public void validarDisponibilidadConsultorio(Integer consultorioId, LocalDate fecha, LocalTime hora) {

        if (turnoRepository.existsByConsultorioIdAndFechaAndHoraAndEstado(consultorioId, fecha, hora, true)) {
            throw new TurnoConflictException("El consultorio ya tiene un turno agendado en esa fecha y horario");
        }
    }


    public void validarHorario(LocalDateTime fechaHora) {
        LocalTime horaInicio = LocalTime.of(8, 0);
        LocalTime horaFin = LocalTime.of(23, 0);
        LocalTime horaTurno = fechaHora.toLocalTime();

        if (fechaHora.getDayOfWeek() == DayOfWeek.SUNDAY
                || horaTurno.isBefore(horaInicio) || horaTurno.isAfter(horaFin)) {
            throw new RuntimeException("Horario de atencion de lunes a sabados de 8 a 23hs");
        }
    }

    public void validarModificarTurno(TurnoModel turno) {


        LocalDateTime fechaHoraTurno = LocalDateTime.of(turno.getFecha(), turno.getHora());
        LocalDateTime ahora = LocalDateTime.now();

        if (Duration.between(ahora, fechaHoraTurno).toHours() < 1) {
            throw new BadRequestException("El turno no puede ser cancelado/modificado faltando menos de una hora.");
        }


    }


}
