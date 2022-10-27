package io.github.matheusgit11.localizacao;

import io.github.matheusgit11.localizacao.domain.entity.Cidade;
import io.github.matheusgit11.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

    @Autowired
    private CidadeRepository cidadeRepository;


    void listarCidadePorNome(){ // teste dos query methods
        cidadeRepository.findByNomeStartingWith("Porto").forEach(System.out::println);
        cidadeRepository.findByNomeEndingWith("a").forEach(System.out::println);
        cidadeRepository.findByNomeContaining("a").forEach(System.out::println);
        cidadeRepository.findByNomeLike("porto%").forEach(System.out::println); // o like funciona com base no %
    }


    public static void main(String[] args) {
        SpringApplication.run(LocalizacaoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      listarCidadePorNome();
    }
}
