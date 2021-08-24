package com.algaworks.algafood.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.Notificador;

@Component
public class AtivacaoClienteService {

	//Podemos indicar o @Autowired aqui também para indicar que esse atributo será instanciado juntamente com essa classe.
	//Mas ai não é possivel indicar outro tipo de notificador, se no caso tivermos mais que um tipo de notificação.
	@Autowired(required = false)
	private Notificador notificador;
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
		if(this.notificador != null) {
			this.notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
		}else {
			System.out.println("Não existe notificador, mas cliente foi ativado");
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
