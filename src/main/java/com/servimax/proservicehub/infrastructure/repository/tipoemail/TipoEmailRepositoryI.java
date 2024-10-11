package com.servimax.proservicehub.infrastructure.repository.tipoemail;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.TipoEmail;

@Repository
public interface TipoEmailRepositoryI extends CrudRepository<TipoEmail, Long>{

}
