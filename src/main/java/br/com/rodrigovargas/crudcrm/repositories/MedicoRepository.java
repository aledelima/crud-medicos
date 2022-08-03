package br.com.rodrigovargas.crudcrm.repositories;

import br.com.rodrigovargas.crudcrm.model.ENUMS.DiaSemana;
import br.com.rodrigovargas.crudcrm.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    Optional<Medico> findMedicoByCrm(String crm);
    Optional<Medico> findMedicoByEmail(String email);
    List<Medico> findAllByNomeContainingIgnoreCase(String nome);
    @Query(value = "SELECT m FROM Medico m JOIN m.horariosAtendimento h WHERE h.diaSemana=?1 AND " +
            "(" +
                "(?2 >= h.horarioInicio AND ?2 <= h.horarioTermino) OR" +
                "(?3 >= h.horarioInicio AND ?3 <= h.horarioTermino)" +
            ")"
    )
    List<Medico> findByHorarios(DiaSemana dia, LocalTime desde, LocalTime ate);

}