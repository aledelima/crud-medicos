package br.com.rodrigovargas.crudcrm.services;

import br.com.rodrigovargas.crudcrm.model.ENUMS.DiaSemana;
import br.com.rodrigovargas.crudcrm.model.Medico;
import br.com.rodrigovargas.crudcrm.repositories.MedicoRepository;
import br.com.rodrigovargas.crudcrm.services.exceptions.DataIntegrityViolationException;
import br.com.rodrigovargas.crudcrm.services.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MedicoServiceImpl implements MedicoService {

    private MedicoRepository repo;

    public List<Medico> findAll() {
        return repo.findAll();
    }

    public Medico findById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Médico não existente. Id: " + id));
    }

    public Medico findByCrm(String crm) {
        return repo.findMedicoByCrm(crm)
                .orElseThrow(() -> new ObjectNotFoundException("Médico não existente. CRM: " + crm));
    }

    public Medico findByEmail(String email) {
        return repo.findMedicoByCrm(email)
                .orElseThrow(() -> new ObjectNotFoundException("Médico não cadastrado. Email: " + email));
    }

    public List<Medico> findByHorariosAtendimento(DiaSemana diaSemana, LocalTime horarioInicial, LocalTime horarioFinal) {
        return repo.findByHorarios(diaSemana, horarioInicial, horarioFinal);
    }

    public List<Medico> findByNome(String nome) {
        return repo.findAllByNomeContainingIgnoreCase(nome);
    }

    public Medico create(Medico medico) {
        repo.findMedicoByCrm(medico.getCrm())
                .ifPresent(m -> {throw new DataIntegrityViolationException("CRM já cadastrado");});

        repo.findMedicoByEmail(medico.getEmail())
                .ifPresent(m -> {throw new DataIntegrityViolationException("Email já cadastrado");});

        return repo.save(medico);
    }

    public Medico update(Medico medico) {
        return null;
    }

    public void delete(Medico medico) {

    }


}
