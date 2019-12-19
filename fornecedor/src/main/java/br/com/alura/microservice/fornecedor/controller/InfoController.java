package br.com.alura.microservice.fornecedor.controller;

import br.com.alura.microservice.fornecedor.model.InfoFornecedor;
import br.com.alura.microservice.fornecedor.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MarcoAntonioGoncalve on Dec, 2019
 */
@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @RequestMapping(value = "/{estado}", method = RequestMethod.GET)
    public InfoFornecedor getInfoPorEstado(@PathVariable String estado){
        return infoService.getInfoPorEstado(estado);
    }

}
