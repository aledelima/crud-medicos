package br.com.rodrigovargas.crudcrm.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String crm;
    @Column(unique = true)
    private String email;
    private String nome;
    private String telefone;
    @Embedded
    private Endereco endereco;
    @ElementCollection
    List<HorarioAtendimento> horariosAtendimento = new ArrayList<>();
}
