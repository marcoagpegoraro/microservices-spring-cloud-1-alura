package br.com.alura.microservice.loja.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Compra {

	private Long pedidoId;
	private Integer tempoDePreparo;
	private String enderecoDestino;
	
}
