 package com.servimax.proservicehub.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator  implements ConstraintValidator<UniqueEmail, String>{
      
    // Inyectar el repositorio o servicio para verificar la unicidad
    // @Autowired
    // private UsuarioRepository usuarioRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null) {
            return true; // La validación de @NotNull se debe hacer por separado
        }

        // Lógica para verificar la unicidad en la base de datos
        // return !usuarioRepository.existsByEmail(email);
        return true; // Cambia esto a la lógica real
    }
}
