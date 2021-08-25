package com.algaworks.algafood.di.service;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.NivelUrgencia;
import com.algaworks.algafood.di.notificacao.Notificador;
import com.algaworks.algafood.di.notificacao.TipoDoNotificador;

@Component
public class AtivacaoClienteService {

	//Podemos indicar o @Autowired aqui também para indicar que esse atributo será instanciado juntamente com essa classe.
	//Mas ai não é possivel indicar outro tipo de notificador, se no caso tivermos mais que um tipo de notificação.
	
	@TipoDoNotificador(NivelUrgencia.URGENTE)
	@Autowired
	private Notificador notificador;
	
	
	//É possível indicar o método que será utilizado nos ciclos de vida do bean sem as anotações @PostConstruct e PreDestroy
	//Usando: @Bean(initMethod = "init", destroyMethod="destroy"), isso poderia ser usado em uma classe de configuração como em aula anterior
	
	@PostConstruct
	public void init() {
		System.out.println("INIT");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("DESTROY");
	}

	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");	
		
	}
		
	/*
	 * podemos indicar também um método para ser o default na instanciação.
	@Autowired
	public void setNotificador(Notificador notificador) {
		this.notificador = notificador;
	}
	*/
	
	
	
}
