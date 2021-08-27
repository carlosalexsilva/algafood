package com.algaworks.algafood.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@Getter
//@Setter
//@EqualsAndHashCode
@Data //O Data faz todos os 3 acima de uma vez Getter, Setter e EqualsAndHashCode
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //indica que EqualsAndHashCode só será feito para o campo explicitamente identificado, 
												  //pois o Data gera para todos os atributos
@Entity
//@Table(name = "cozinha") - comentado pq a tabela vai chamar cozinha
public class Cozinha {

	@EqualsAndHashCode.Include
	@Id //chave primary da Tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;	
	
}
