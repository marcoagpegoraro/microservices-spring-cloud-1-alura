package br.com.alura.microservice.loja.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by MarcoAntonioGoncalve on Dec, 2019
 */
@Getter
@Setter
public class EnderecoDTO {
    private String rua;
    private Integer numero;
    private String estado;
	
    @Override
	public String toString() {
		return "EnderecoDTO [rua=" + rua + ", numero=" + numero + ", estado=" + estado + "]";
	}
    
}
