package br.paulotrc.svcspc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SvcSpcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SvcSpcApplication.class, args);
    }

}
