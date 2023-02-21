package br.paulotrc.svcspc.iteractors;

import br.paulotrc.svcspc.entites.Spc;
import br.paulotrc.svcspc.repositories.SpcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpcUseCase {

    private SpcRepository spcRepository;

    public SpcUseCase(SpcRepository spcRepository) {
        this.spcRepository = spcRepository;
    }

    public Spc gravarSpc(Spc spc) {
        return spcRepository.save(spc);
    }

    public List<Spc> consultaTodos() {
        return spcRepository.findAll();
    }

    public List<Spc> consultarPorCpf(String cpf) {
        return spcRepository.consultarPorCpf(cpf);
    }
}
