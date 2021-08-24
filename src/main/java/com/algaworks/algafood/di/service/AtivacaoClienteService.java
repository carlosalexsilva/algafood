package com.algaworks.algafood.di.service;


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
