package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Component
public class RestauranteService {

	@Autowired
	public RestauranteRepository restauranteRepository;
	
	
	
}
