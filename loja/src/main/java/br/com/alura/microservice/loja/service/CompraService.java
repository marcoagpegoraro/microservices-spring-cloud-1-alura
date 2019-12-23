package br.com.alura.microservice.loja.service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.dto.CompraDTO;
import br.com.alura.microservice.loja.dto.InfoFornecedorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by MarcoAntonioGoncalve on Dec, 2019
 */
@Service
public class CompraService {

//    @Autowired
//    private RestTemplate client;
//
//    @Autowired
//    private DiscoveryClient eurekaClient;

	@Autowired
	private FornecedorClient fornecedorClient;
	
    public void realizaCompra(CompraDTO compraDTO) {

//        ResponseEntity<InfoFornecedorDTO> exchange =
//                client.exchange("http://fornecedor/info/"+compraDTO.getEndereco().getEstado()
//        , HttpMethod.GET, null, InfoFornecedorDTO.class);
//
//        eurekaClient.getInstances("fornecedor").stream()
//                .forEach(fornecedor -> {
//                    System.out.println("localhost"+fornecedor.getPort());
//                });
//        System.out.println(exchange.getBody().getEndereco());
    	
    	InfoFornecedorDTO infoFornecedorDTO = fornecedorClient.getInfoPorEstado(compraDTO.getEndereco().getEstado());
    	
    	System.out.print(infoFornecedorDTO.getEndereco());
    }
}