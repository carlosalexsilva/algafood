package com.algaworks.algafood;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.di.notificacao.Notificador;
import com.algaworks.algafood.di.service.AtivacaoClienteService;

@Configuration
public class ServiceConfig {

	@Bean
	public AtivacaoClienteService ativacaoClienteService(Notificador notificador) {
		return new AtivacaoClienteService(notificador); 
		//passando a interface Notificador que irá usar o metodo notificarEmail , passando como um bean gerenciado
		//mesmo que esse construtor notificarEmail esteja em outra classe de configuração 
	}
}
