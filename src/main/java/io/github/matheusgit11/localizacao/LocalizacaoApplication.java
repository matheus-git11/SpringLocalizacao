package io.github.matheusgit11.localizacao;

import io.github.matheusgit11.localizacao.domain.entity.Cidade;
import io.github.matheusgit11.localizacao.domain.repository.CidadeRepository;
import io.github.matheusgit11.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

    @Autowired
    private CidadeService service;

    public static void main(String[] args) {
        SpringApplication.run(LocalizacaoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // service.testeQueryMethodsCidadesPorNome();
       // service.testQueryMethodsCidadesPorHabitantes();
       // service.testQueryMethodsCompostas();
       // service.testQueryMethodsSortAndPage();
       // var cidade = new Cidade(null,"porto",null); //service.filtroDinamico(cidade).forEach(System.out::println);
       // service.listarCidadesByNomeSpec();
        var cidade = new Cidade(null,null,1L);
        service.listarCidadesSpecsFiltroDinamico(cidade);
    }
}
