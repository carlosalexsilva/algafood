package com.algaworks.algafood.api.model;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;
import lombok.NonNull;

@JacksonXmlRootElement(localName = "cozinhas")
@Data
public class CozinhasXmlWrapper {

	@NonNull //indica que é obrigatório e assim é criado um controlador eplo lombok
	@JsonProperty("cozinhas")
	@JacksonXmlElementWrapper(useWrapping = false)
	public List<Cozinha> cozinhas;
}
