package com.servimax.proservicehub.infrastructure.repository.rol;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.servimax.proservicehub.domain.entity.Rol;

// ................... jparepository

@Repository
public interface RolRepositoryI extends JpaRepository<Rol, Long>{
    Optional<Rol> findByNombre(String nombre);
}
