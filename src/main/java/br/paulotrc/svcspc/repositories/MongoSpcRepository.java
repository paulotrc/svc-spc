package br.paulotrc.svcspc.repositories;

import br.paulotrc.svcspc.entites.Spc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MongoSpcRepository extends MongoRepository<Spc, UUID> {

    @Query("{cpf: { $regex: ?0 } })")
    List<Spc> consultarPorCpf(String cpf);
}
