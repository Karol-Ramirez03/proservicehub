package com.servimax.proservicehub.infrastructure.repository.operation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.servimax.proservicehub.domain.entity.segurity.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

    @Query("SELECT o FROM Operation o where o.permitAll = true")
    List<Operation> findByPubliccAcces();
}
