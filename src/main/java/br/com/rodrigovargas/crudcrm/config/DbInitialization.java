package br.com.rodrigovargas.crudcrm.config;

import br.com.rodrigovargas.crudcrm.model.ENUMS.DiaSemana;
import br.com.rodrigovargas.crudcrm.model.ENUMS.UF;
import br.com.rodrigovargas.crudcrm.model.Endereco;
import br.com.rodrigovargas.crudcrm.model.HorarioAtendimento;
import br.com.rodrigovargas.crudcrm.model.Medico;
import br.com.rodrigovargas.crudcrm.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;
import java.util.Arrays;

@Configuration
public class DbInitialization {

    @Autowired
    MedicoRepository medicoRepository;

    @Bean
    public void dbSeed() {
        Endereco endereco = Endereco.builder()
                .uf(UF.RJ)
                .cidade("Rio de Janeiro")
                .cep("21280-280")
                .bairro("Catete")
                .logradouro("Rua do Catete")
                .numero("18A")
                .build();

        HorarioAtendimento segunda = HorarioAtendimento.builder()
                .diaSemana(DiaSemana.SEG)
                .horarioInicio(LocalTime.of(8, 0))
                .horarioTermino(LocalTime.of(17, 0))
                .build();

        HorarioAtendimento quarta = HorarioAtendimento.builder()
                .diaSemana(DiaSemana.QUA)
                .horarioInicio(LocalTime.of(8, 0))
                .horarioTermino(LocalTime.of(17, 0))
                .build();

        HorarioAtendimento sexta = HorarioAtendimento.builder()
                .diaSemana(DiaSemana.SEX)
                .horarioInicio(LocalTime.of(8, 0))
                .horarioTermino(LocalTime.of(12, 0))
                .build();

        Medico drJoao = Medico.builder()
                .nome("João José Gomes")
                .crm("123987456")
                .telefone("234-5678")
                .email("drjoaojosegomes@gmail.com")
                .endereco(endereco)
                .horariosAtendimento(Arrays.asList(segunda, quarta, sexta))
                .build();

        medicoRepository.save(drJoao);
    }

}
