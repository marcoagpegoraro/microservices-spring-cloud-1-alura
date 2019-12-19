package br.com.alura.microservice.fornecedor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by MarcoAntonioGoncalve on Dec, 2019
 */
@Entity
@Getter
@Setter
public class InfoFornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String estado;
    private String endereco;
}
