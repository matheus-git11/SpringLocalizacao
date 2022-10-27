package io.github.matheusgit11.localizacao.domain.repository;

import io.github.matheusgit11.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade,Long> {


    @Query(" select c from Cidade c where upper(c.nome) like upper(?1)") // tratando casos de case sensitive
    List<Cidade> findByNomeLike(String nome); //funciona se passarmos juntos de um % , sendo no inicio, final ou cercando o conteudo
                                              // ou se passarmos apenas o conteudo

    List<Cidade> findByNome(String nome);  //busca pelo nome
    List<Cidade> findByNomeStartingWith(String nome); //busca pelo nome comecando por aquele pedaco

    List<Cidade> findByNomeEndingWith(String nome); //busca pelo nome terminando por aquele pedaco

    List<Cidade> findByNomeContaining(String nome); // busca pelo nome contendo  aquele pedacoo

    List<Cidade> findByHabitantes(Long habitantes);



}
