package com.algaworks.algafood.domain.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends CustomJpaRepository<Cozinha, Long>{
	//JpaRepository<Cozinha, Long>
	//<Classe que será utilizada, Tipo do campo ID

	/*
	 * Métodos LISTAR, BUSCAR, SALVAR, REMOVE SERÃO IMPLEMENTADOS PELO SPRING DATA JPA
	 */
	List<Cozinha> findTodasByNomeContaining(String nome);
	Optional<Cozinha> findByNome(String nome);
	//Cozinha findCozinhaByNome(String nome); podemos fazer um metodo pra trazer somente um registro
	
	boolean existsByNome(String nome);
	
}
