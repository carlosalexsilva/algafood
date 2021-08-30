package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;

	@GetMapping
	public List<Cozinha> listar() {
		return cozinhaRepository.listar();
	}
	
	@GetMapping("/{cozinhaId}") // => {cozinhaId} é conhecido como PathVariable
	//public Cozinha buscar(@PathVariable("cozinhaId") Long id) { => Poderia ser feito assim também
	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);
		
		//return ResponseEntity.status(HttpStatus.OK).body(cozinha); modelo para definir o status que eu quiser usando o ResponseEntity
		
		//return ResponseEntity.ok(cozinha); 
		// essa linhha é um atalho para o tipo de resposta da linha acima, porém a linha acima é possível 
		//criar ifs para condicionar a resposta
		
		// No exemplo abaixo, estamos usando o responde de um found que indica que a página foi redirecionada temporariamente
		// para outra url, por isso um teste simples passando o listar todas cozinhas.
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.LOCATION, "http://localhost/cozinhas");
		
		return ResponseEntity
				.status(HttpStatus.FOUND)
				.headers(headers)
				//.body(cozinha);
				.build();
	}
	
}
