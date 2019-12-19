package br.com.alura.microservice.fornecedor.repository;

import br.com.alura.microservice.fornecedor.model.InfoFornecedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by MarcoAntonioGoncalve on Dec, 2019
 */
@Repository
public interface InfoRepository  extends CrudRepository<InfoFornecedor, Long> {
    InfoFornecedor findByEstado(String estado);
}
