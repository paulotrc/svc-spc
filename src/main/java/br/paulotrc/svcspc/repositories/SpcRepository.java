package br.paulotrc.svcspc.repositories;

import br.paulotrc.svcspc.entites.Spc;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SpcRepository {

        Spc save(Spc spc);
        List<Spc> findAll();
        List<Spc> consultarPorCpf(String cpf);

    }

