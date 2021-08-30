package com.algaworks.algafood.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonRootName("gastronomia") // -> usado para xml altera o nome do nível para essa classe
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
	
	//@JsonIgnore -> nao exibe esse atributo na resposta 
	@Column(nullable = false)
	private String nome;	
	
}
