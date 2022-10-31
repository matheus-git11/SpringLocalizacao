package io.github.matheusgit11.localizacao.service;

import io.github.matheusgit11.localizacao.domain.entity.Cidade;
import io.github.matheusgit11.localizacao.domain.repository.CidadeRepository;
import static io.github.matheusgit11.localizacao.domain.repository.specs.CidadeSpecs.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    private final CidadeRepository repository;

    public CidadeService(CidadeRepository repository){
        this.repository = repository;
    }

    public void testeQueryMethodsCidadesPorNome(){ // teste dos query methods por nome (usando String)
        repository.findByNomeStartingWith("Porto").forEach(System.out::println);
        repository.findByNomeEndingWith("a").forEach(System.out::println);
        repository.findByNomeContaining("a").forEach(System.out::println);
    }

    public void testQueryMethodsCidadesPorHabitantes(){ // teste de query methods por Habitantes (Usando numero)
        repository.findByHabitantesLessThan(13940233L).forEach(System.out::println);
        repository.findByHabitantesLessThanEqual(13940233L).forEach(System.out::println);
        repository.findByHabitantesGreaterThan(533421633L).forEach(System.out::println);
        repository.findByHabitantesGreaterThanEqual(533421633L).forEach(System.out::println);
    }

    public void testQueryMethodsSortAndPage(){ // testando paginacao e ordenacao by query methods
        Pageable pageable = PageRequest.of(1,3);
        repository.findByNomeLike("porto%", Sort.by("habitantes")).forEach(System.out::println);
        repository.findByNomeLike("%%%%", pageable).forEach(System.out::println);
    }

    public void testQueryMethodsCompostas(){
        repository
                .findByHabitantesLessThanAndNomeLike(13940233L,"Re%")
                .forEach(System.out::println);
    }

    public List<Cidade> filtroDinamico(Cidade cidade){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()// podemos usar o matcher para personalizar o nosso example
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        Example<Cidade> example = Example.of(cidade,matcher); // podemos passar apenas o objeto ou o matcher como segundo atributo
        return repository.findAll(example);
    }

    public void listarCidadesByNomeSpec(){
        repository
                .findAll(nomeEqual("Sao Paulo")
                        .or(habitantesGreaterThan(1000)))
                        .forEach(System.out::println);
    }












}
