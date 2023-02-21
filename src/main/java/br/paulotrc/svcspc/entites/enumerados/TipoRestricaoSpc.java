package br.paulotrc.svcspc.entites.enumerados;

public enum TipoRestricaoSpc {
    DIVIDA("Dívida"),
    SITUACAO_CADASTRAL("Situação Cadastral"),
    CPF_CANCELADO("CPF Cancelado"),
    CPF_PENDENTE("CPF Pendente"),
    CPF_NULO("CPF Nulo");

    private String descricao;

    TipoRestricaoSpc(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    
}
