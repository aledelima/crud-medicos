package br.com.rodrigovargas.crudcrm.model;

import br.com.rodrigovargas.crudcrm.model.ENUMS.DiaSemana;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Embeddable
public class HorarioAtendimento {
    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;
    private LocalTime horarioInicio;
    private LocalTime horarioTermino;
}
