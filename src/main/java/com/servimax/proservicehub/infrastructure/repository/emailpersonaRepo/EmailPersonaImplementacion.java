package com.servimax.proservicehub.infrastructure.repository.emailpersonaRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servimax.proservicehub.application.service.EmailPersonaServiceI;
import com.servimax.proservicehub.domain.entity.EmailPersona;

@Service
public class EmailPersonaImplementacion implements EmailPersonaServiceI{

    @Autowired
    private EmailPersonaRepository emailPersonaRepository;

    @Override
    public List<EmailPersona> findAll() {
        return ((List<EmailPersona>)emailPersonaRepository.findAll());
    }

    @Override
    public Optional<EmailPersona> findById(Long id) {
        return emailPersonaRepository.findById(id);
    }

    @Override
    public EmailPersona save(EmailPersona emailPersona) {
        return emailPersonaRepository.save(emailPersona);
    }

    @Override
    public Optional<EmailPersona> update(Long id, EmailPersona emailPersona) {
        return emailPersonaRepository.findById(id).map(existingEmailPersona -> {
            existingEmailPersona.setEmail(emailPersona.getEmail());
            existingEmailPersona.setPersonas(emailPersona.getPersonas());
            existingEmailPersona.setTipoEmail(emailPersona.getTipoEmail());
            return emailPersonaRepository.save(existingEmailPersona);
        });
    }

    @Override
    public Optional<EmailPersona> delete(Long id) {
        Optional<EmailPersona> emailPersonaOptional = emailPersonaRepository.findById(id);
        emailPersonaOptional.ifPresent(emailPersona -> emailPersonaRepository.delete(emailPersona));
        return emailPersonaOptional;
    }
}
