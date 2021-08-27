package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;

public class BuscaCozinhaMain {
	
	public static void main(String[] args) {
		
		//COMANDO UTILIZADO PARA INSTANCIAR A APLICAÇÃO MAS NÃO EM MODO WEB, OU SEJA INICIA E JÁ MORRE A APLICAÇÃO
		//NÃO FICA AGUARDANDO UMA REQUISIÇÃO COMO NO MODO WEB.
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
		
		Cozinha cozinha = cadastroCozinha.buscar(1L);
		
		System.out.println(cozinha.getNome());
		
	}
}
