package br.com.rodrigovargas.crudcrm.model;

import br.com.rodrigovargas.crudcrm.model.ENUMS.UF;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Endereco {

    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    @Enumerated(EnumType.STRING)
    private UF uf;
    private String cep;
}
