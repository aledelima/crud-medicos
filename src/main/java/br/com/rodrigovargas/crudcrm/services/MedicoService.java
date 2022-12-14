package br.com.rodrigovargas.crudcrm.services;

import br.com.rodrigovargas.crudcrm.model.ENUMS.DiaSemana;
import br.com.rodrigovargas.crudcrm.model.Medico;

import java.time.LocalTime;
import java.util.List;

public interface MedicoService {

    List<Medico> findAll();
    Medico findById(Integer id);
    Medico findByCrm(String crm);
    Medico findByEmail(String email);
    List<Medico> findByHorariosAtendimento(DiaSemana diaSemana, LocalTime horarioInicial, LocalTime horarioFinal);
    List<Medico> findByNome(String nome);
    Medico create(Medico medico);
    Medico update(Medico medico);
    void delete(Integer id);

}
