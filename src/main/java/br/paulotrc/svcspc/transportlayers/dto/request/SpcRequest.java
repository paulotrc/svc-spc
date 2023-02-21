package br.paulotrc.svcspc.transportlayers.dto.request;

import br.paulotrc.svcspc.entites.enumerados.TipoRestricaoSpc;
import br.paulotrc.svcspc.entites.validators.TipoRestricaoSpcValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class SpcRequest {

    private UUID id = UUID.randomUUID();
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;
    @NotNull(message = "Indicativo de se tem restrição é obrigatório")
    private Boolean temRestricao;
    @TipoRestricaoSpcValidator(regexp = "DIVIDA|SITUACAO_CADASTRAL|CPF_CANCELADO|CPF_PENDENTE|CPF_NULO")
    private TipoRestricaoSpc tipoRestricaoSpc;
    @PositiveOrZero(message = "Valor da restrição deve ser maior que zero ou zero.")
    private BigDecimal valorRestricao;
}

