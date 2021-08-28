package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@RestController
//@RequestMapping("/cozinhas")
@RequestMapping(value = "/cozinhas", produces = MediaType.APPLICATION_JSON_VALUE) // aqui a classe inteira irá responder somente em JSON
public class CozinhaController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	//@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) - isso indica que esse método só poderá retornar resposta json
	//@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }) //usando array para permitir mais de um tipo
	public List<Cozinha> listar() {
		return cozinhaRepository.listar();
	}
	
}
