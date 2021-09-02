package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepository{

	@PersistenceContext // Injetando o EntityManager
	private EntityManager manager;
	
	@Override
	public List<Restaurante> listar() {
		
		return manager.createQuery("from Restaurante", Restaurante.class)
				.getResultList();
	}
	
	@Override
	public Restaurante buscar(Long id) {
		return manager.find(Restaurante.class, id);
	}
	
	@Override
	@Transactional
	public Restaurante salvar(Restaurante restaurante) {
		return manager.merge(restaurante);
		
	}
	
	@Override
	@Transactional
	public void remover(Long restauranteId) {
		
		Restaurante restaurante = buscar(restauranteId);
		if (restaurante == null) {
			throw new EmptyResultDataAccessException(1); //para é a quantidade de restaurante que esperava
		}
		manager.remove(restaurante);		
	}
}
