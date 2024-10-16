package com.servimax.proservicehub.application.service;

import java.util.List;
import java.util.Optional;

import com.servimax.proservicehub.domain.entity.EmailPersona;

public interface EmailPersonaServiceI {

    List<EmailPersona> findAll();
    Optional<EmailPersona> findById(Long id);
    EmailPersona save(EmailPersona emailPersona);
    Optional<EmailPersona> update(Long id, EmailPersona emailPersona);
    Optional<EmailPersona> delete(Long id);
}
