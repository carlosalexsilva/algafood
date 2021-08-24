package com.algaworks.algafood.di.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.Notificador;

@Component
public class AtivacaoClienteService {

	//Podemos indicar o @Autowired aqui também para indicar que esse atributo será instanciado juntamente com essa classe.
	//Mas ai não é possivel indicar outro tipo de notificador, se no caso tivermos mais que um tipo de notificação.
	@Autowired
	private List<Notificador> notificadores;
	/*
	 * PODEMOS USAR O AUTOWIRED AQUI PARA INDICAR QUE ESSE CONSTRUTOR IRÁ INSTANCIAR O NOTIFICADOR TAMBÉM
	@Autowired
	public AtivacaoClienteService(Notificador notificador) {
		this.notificador = notificador;
		
		System.out.println("AtivacaoClienteService:" + notificador);
	}
	*/



	public void ativar(Cliente cliente) {
		cliente.ativar();
		for(Notificador notificador : notificadores) {
			notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");	
		}
	}
		

	/*
	 * podemos indicar também um método para ser o default na instanciação.
	@Autowired
	public void setNotificador(Notificador notificador) {
		this.notificador = notificador;
	}
	*/
	
	
	
}
