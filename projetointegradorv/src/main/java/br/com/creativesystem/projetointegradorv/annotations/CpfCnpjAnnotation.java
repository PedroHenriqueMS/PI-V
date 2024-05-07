package br.com.creativesystem.projetointegradorv.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.creativesystem.projetointegradorv.validator.CpfCnpjValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

// TODO: Auto-generated Javadoc
/**
 * The Interface CpfCnpjAnnotation.
 */
@Documented
@Constraint(validatedBy = CpfCnpjValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfCnpjAnnotation {
    
    /**
     * Message.
     *
     * @return the string
     */
    String message() default "CPF/CNPJ inválido";
     
     /**
      * Groups.
      *
      * @return the class[]
      */
     Class<?>[] groups() default {};
     
     /**
      * Payload.
      *
      * @return the Class ? extends payload []
      */
     Class<? extends Payload>[] payload() default{};
}
