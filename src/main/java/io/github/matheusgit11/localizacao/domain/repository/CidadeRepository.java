package io.github.matheusgit11.localizacao.domain.repository;

import io.github.matheusgit11.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade,Long> {


    List<Cidade> findByNome(String nome);  //busca pelo nome
    List<Cidade> findByNomeStartingWith(String nome); //busca pelo nome comecando por aquele pedaco

    List<Cidade> findByNomeEndingWith(String nome); //busca pelo nome terminando por aquele pedaco

    List<Cidade> findByNomeContaining(String nome); // busca pelo nome contendo  aquele pedcao

    List<Cidade> findByHabitantes(Long habitantes);
}
