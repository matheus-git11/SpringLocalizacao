package io.github.matheusgit11.localizacao.domain.repository;

import io.github.matheusgit11.localizacao.domain.entity.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade,Long> , JpaSpecificationExecutor<Cidade> {

    //ordenado
    @Query(" select c from Cidade c where upper(c.nome) like upper(?1)")
    List<Cidade> findByNomeLike(String nome, Sort sort);

    //paginado
    @Query(" select c from Cidade c where upper(c.nome) like upper(?1)")
    Page<Cidade> findByNomeLike(String nome, Pageable pageable);

    List<Cidade> findByNome(String nome);  //busca pelo nome
    List<Cidade> findByNomeStartingWith(String nome); //busca pelo nome comecando por aquele pedaco

    List<Cidade> findByNomeEndingWith(String nome); //busca pelo nome terminando por aquele pedaco

    List<Cidade> findByNomeContaining(String nome); // busca pelo nome contendo aquele pedaco

    List<Cidade> findByHabitantes(Long habitantes); // busca por habitantes iguais ao valor passado

    List<Cidade> findByHabitantesLessThan(Long habitantes); // busca por habitantes Menores que o valor passado

    List<Cidade> findByHabitantesGreaterThan(Long habitantes); // busca por habitantes Maiores que o valor passado

    List<Cidade> findByHabitantesLessThanEqual(Long habitantes); // busca por habitantes Menores ou iguais que o valor passado

    List<Cidade> findByHabitantesGreaterThanEqual(Long habitantes); // busca por habitantes Maiores ou iguais que o valor passado

    List<Cidade> findByHabitantesLessThanAndNomeLike(Long habitantes , String nome); // Busca composta com habitantes e nome



}
