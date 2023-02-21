package br.paulotrc.svcspc.transportlayers.dto.request;

import br.paulotrc.svcspc.entites.enumerados.TipoRestricaoSpc;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class SpcRequest {

    private UUID id;
    private String cpf;
    private Boolean temRestricao;
    private TipoRestricaoSpc tipoRestricaoSpc;
    private BigDecimal valorRestricao;
}

