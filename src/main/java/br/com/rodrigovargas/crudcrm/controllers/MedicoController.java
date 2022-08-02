package br.com.rodrigovargas.crudcrm.controllers;

import br.com.rodrigovargas.crudcrm.model.ENUMS.DiaSemana;
import br.com.rodrigovargas.crudcrm.model.Medico;
import br.com.rodrigovargas.crudcrm.services.MedicoService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/medicos")
@AllArgsConstructor
public class MedicoController {

    private MedicoService service;

    @RequestMapping()
    public ResponseEntity<List<Medico>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Medico> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @RequestMapping("/crm/{crm}")
    public ResponseEntity<Medico> findByCrm(@PathVariable String crm) {
        return ResponseEntity.ok(service.findByCrm(crm));
    }

    @RequestMapping("/nome/{nome}")
    public ResponseEntity<List<Medico>> findByNome(@PathVariable String nome) {
        return ResponseEntity.ok(service.findByNome(nome));
    }

    @RequestMapping("/horarios/dia-semana/{dia}/desde/{desde}/ate/{ate}")
    public ResponseEntity<List<Medico>> findByHorarios(@PathVariable DiaSemana dia,
                                                       @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime desde,
                                                       @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime ate) {
        System.out.println(desde);
        System.out.println(ate);
        return ResponseEntity.ok(service.findByHorariosAtendimento(dia, desde, ate));
    }


}
