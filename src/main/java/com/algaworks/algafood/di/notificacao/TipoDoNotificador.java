package com.algaworks.algafood.di.notificacao;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.beans.factory.annotation.Qualifier;

@Retention(RetentionPolicy.RUNTIME) //diz quanto tempo essa anotação deve permanecer ativa. Adicionando RetentionPolicy.RUNTIME, ela irá funcionar em todos os lugares que for usada a anotação TipoDoNotificador
@Qualifier
public @interface TipoDoNotificador {

	NivelUrgencia value(); //value() é simplesmente para a hora de usar a notação não precisar definir value=NivelUrgencia.NORMAL
}
