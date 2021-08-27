package com.algaworks.algafood.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Cozinha;

@Component
public class CadastroCozinha {

	@PersistenceContext // Injetando o EntityManager
	private EntityManager manager;
	
	public List<Cozinha> listar() {
		//somente o from Cozinha, traz todos os atributes da cozinha
		//TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);		
		//return query.getResultList();
		
		return manager.createQuery("from Cozinha", Cozinha.class)
				.getResultList();
	}
}
