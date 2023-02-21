package br.paulotrc.svcspc.transportlayers.impl;

import br.paulotrc.svcspc.entites.Spc;
import br.paulotrc.svcspc.exceptions.ExceptionUtil;
import br.paulotrc.svcspc.exceptions.ResourceException;
import br.paulotrc.svcspc.iteractors.SpcUseCase;
import br.paulotrc.svcspc.transportlayers.SpcResourceI;
import br.paulotrc.svcspc.transportlayers.dto.request.SpcRequest;
import br.paulotrc.svcspc.transportlayers.dto.response.SpcResponse;
import br.paulotrc.svcspc.transportlayers.mappers.SpcMapper;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class SpcResource implements SpcResourceI {

    private SpcUseCase spcUseCase;

    public SpcResource(SpcUseCase spcUseCase) {
        this.spcUseCase = spcUseCase;
    }

    @Override
    public ResponseEntity<List<SpcResponse>> get(
            @Parameter(name = "cpf", description = "Número do CPF do Cliente", required = true)
            @PathVariable("cpf") String cpf
    ) {
        List<Spc> spcs = null;
        try {
            spcs = spcUseCase.consultarPorCpf(cpf);
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(SpcMapper.INSTANCE.mapListResponse(spcs));
    }

    @Override
    public ResponseEntity<List<SpcResponse>> getAll() {
        List<Spc> spcs = null;
        try {
            spcs = spcUseCase.consultaTodos();
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(SpcMapper.INSTANCE.mapListResponse(spcs));
    }

    @Override
    public ResponseEntity<SpcResponse> post(@Valid @RequestBody SpcRequest spcRequest) {
        Spc spc = null;
        try {
            spc = spcUseCase.gravarSpc(SpcMapper.INSTANCE.map(spcRequest));
        }catch (ResourceException e){
            ExceptionUtil.throwException(e);
        }
        return ResponseEntity.ok(SpcMapper.INSTANCE.mapResponse(spc));
    }
}
