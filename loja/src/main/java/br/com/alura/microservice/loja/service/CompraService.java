package br.com.alura.microservice.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.dto.CompraDTO;
import br.com.alura.microservice.loja.dto.InfoFornecedorDTO;
import br.com.alura.microservice.loja.dto.InfoPedidoDTO;
import br.com.alura.microservice.loja.model.Compra;

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

	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
	
	@Autowired
	private FornecedorClient fornecedorClient;
	
	@HystrixCommand(fallbackMethod = "realizaCompraFallback")
    public Compra realizaCompra(CompraDTO compraDTO) {

//        ResponseEntity<InfoFornecedorDTO> exchange =
//                client.exchange("http://fornecedor/info/"+compraDTO.getEndereco().getEstado()
//        , HttpMethod.GET, null, InfoFornecedorDTO.class);
//
//        eurekaClient.getInstances("fornecedor").stream()
//                .forEach(fornecedor -> {
//                    System.out.println("localhost"+fornecedor.getPort());
//                });
//        System.out.println(exchange.getBody().getEndereco());
    	
    	final String estadoFornecedor = compraDTO.getEndereco().getEstado();
    	
    	InfoFornecedorDTO infoFornecedorDTO = fornecedorClient.getInfoPorEstado(estadoFornecedor);
    	
    	LOG.info("Buscando informações do fornecedor de {}", estadoFornecedor);
    	InfoPedidoDTO infoPedidoDTO = fornecedorClient.realizaPedido(compraDTO.getItens());
    	
    	LOG.info("Realizando um pedido");
    	Compra compraSalva = Compra.builder()
    			.pedidoId(infoPedidoDTO.getId())
    			.tempoDePreparo(infoPedidoDTO.getTempoDePreparo())
    			.enderecoDestino(compraDTO.getEndereco().toString())
    			.build();
    	
    	return compraSalva;
	}

		public Compra realizaCompraFallback(CompraDTO compraDTO) {
			Compra compraFallback = Compra.builder()
	    			.enderecoDestino(compraDTO.getEndereco().toString())
	    			.build();
	    	
	    	return compraFallback;	
		}

}