package com.algaworks.algafood.infrastructure.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepositoryQueries;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurante> find(String nome, 
			BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){

		//Interface CriteriaBuilder tipo fabrica que disponibiliza tipos de clausulas para gerar a query
		CriteriaBuilder builder = manager.getCriteriaBuilder(); 
		
		//CriteriaQuery - é um construtor de clausulas		
		CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);
		Root<Restaurante> root = criteria.from(Restaurante.class); // from Restaurante (root) é o Restaurante
		
		//Predicate é como um filtro, passar sempre o atributo através do root.get
		var predicates = new ArrayList<Predicate>();
		if (StringUtils.hasText(nome)) {
			predicates.add(builder.like(root.get("nome"), "%" + nome + "%"));
		}
		
		if (taxaFreteInicial != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));
		}
		
		if (taxaFreteFinal != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));
		}
		
		//Convertendo uma ArrayList em um Array, isso é uma das formas de converter qualquer tipo de lista em um array.
		criteria.where(predicates.toArray(new Predicate[0])); 
		
		TypedQuery<Restaurante> query = manager.createQuery(criteria);		
		return query.getResultList();
		
		//return manager.createQuery("from Restaurante", Restaurante.class).getResultList(); - CONSULTA JPQL DO JPA.
		
		/*
		 * Nessa versão do java, poderiamos também usar a declaração das variaveis assim
		 * var builder = manager.getCriteriaBuilder(); var criteria =
		 * builder.createQuery(Restaurante.class); var root =
		 * criteria.from(Restaurante.class); // from Restaurante (root) é o Restaurante
		 * var query = manager.createQuery(criteria);
		 */
		
	}
}
