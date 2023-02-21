package br.paulotrc.svcspc.datasources;

import br.paulotrc.svcspc.entites.Spc;
import br.paulotrc.svcspc.repositories.SpcRepository;
import br.paulotrc.svcspc.repositories.MongoSpcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpcDataSource implements SpcRepository {

    private final Logger log = LoggerFactory.getLogger(SpcDataSource.class);
    private MongoSpcRepository mongoSpcRepository;

    public SpcDataSource(MongoSpcRepository mongoSpcRepository) {
        this.mongoSpcRepository = mongoSpcRepository;
    }

    public Spc save(Spc spc){
        return this.mongoSpcRepository.save(spc);
    }

    public List<Spc> findAll(){
        return this.mongoSpcRepository.findAll();
    }

    @Override
    public List<Spc> consultarPorCpf(String cpf) {
        return mongoSpcRepository.consultarPorCpf(cpf);
    }
}
