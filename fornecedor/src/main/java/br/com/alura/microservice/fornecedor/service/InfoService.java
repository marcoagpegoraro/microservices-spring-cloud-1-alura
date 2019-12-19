package br.com.alura.microservice.fornecedor.service;

import br.com.alura.microservice.fornecedor.model.InfoFornecedor;
import br.com.alura.microservice.fornecedor.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MarcoAntonioGoncalve on Dec, 2019
 */
@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;

    public InfoFornecedor getInfoPorEstado(String estado) {

        return infoRepository.findByEstado(estado);
    }
}
