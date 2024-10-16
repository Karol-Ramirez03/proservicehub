package com.servimax.proservicehub.infrastructure.repository.tipoemail;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.TipoEmail;

@Repository
public interface TipoEmailRepositoryI extends CrudRepository<TipoEmail, Long>{
    Optional<TipoEmail> findByNombre(String nombre);
}
