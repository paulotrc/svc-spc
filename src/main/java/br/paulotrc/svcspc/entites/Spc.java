package br.paulotrc.svcspc.entites;

import br.paulotrc.svcspc.entites.enumerados.TipoRestricaoSpc;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@Document //Anotação mongo para mapeamento do document.
public class Spc {

    @Id
    private UUID id = UUID.randomUUID();
    private String cpf;
    private Boolean temRestricao;
    private TipoRestricaoSpc tipoRestricaoSpc;
    private BigDecimal valorRestricao;
}

