package br.com.rodrigovargas.crudcrm.repositories;

import br.com.rodrigovargas.crudcrm.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    Optional<Medico> findMedicoByCrm(String crm);
    List<Medico> findAllByNomeContainingIgnoreCase(String nome);

}