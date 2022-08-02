package br.com.rodrigovargas.crudcrm.repositories;

import br.com.rodrigovargas.crudcrm.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}
