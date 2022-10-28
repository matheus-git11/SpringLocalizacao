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


    void testeQueryMethodsCidadesPorNome(){ // teste dos query methods por nome (usando String)
        cidadeRepository.findByNomeStartingWith("Porto").forEach(System.out::println);
        cidadeRepository.findByNomeEndingWith("a").forEach(System.out::println);
        cidadeRepository.findByNomeContaining("a").forEach(System.out::println);
        cidadeRepository.findByNomeLike("porto%").forEach(System.out::println); // o like funciona com base no %
    }

    void testQueryMethodsCidadesPorHabitantes(){ // teste de query methods por Habitantes (Usando numero)
        cidadeRepository.findByHabitantesLessThan(13940233L).forEach(System.out::println);
        cidadeRepository.findByHabitantesLessThanEqual(13940233L).forEach(System.out::println);
        cidadeRepository.findByHabitantesGreaterThan(533421633L).forEach(System.out::println);
        cidadeRepository.findByHabitantesGreaterThanEqual(533421633L).forEach(System.out::println);
    }

    void testQueryMethodsCompostas(){
        cidadeRepository
                .findByHabitantesLessThanAndNomeLike(13940233L,"Re%")
                .forEach(System.out::println);
    }


    public static void main(String[] args) {
        SpringApplication.run(LocalizacaoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       //testeQueryMethodsCidadesPorNome();
        //testQueryMethodsCidadesPorHabitantes();
        testQueryMethodsCompostas();
    }
}
