package br.com.creativesystem.projetointegradorv.validator;

import br.com.creativesystem.projetointegradorv.annotations.CpfCnpjAnnotation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;



// TODO: Auto-generated Javadoc
/**
 * The Class CpfCnpjValidator.
 */
public class CpfCnpjValidator implements ConstraintValidator<CpfCnpjAnnotation, Object> {

    /**
     * Checks if is valid.
     *
     * @param value the value
     * @param context the context
     * @return true, if is valid
     */
    @Override
public boolean isValid(Object value, ConstraintValidatorContext context) {
    if (value == null) return true; // Permitir valor nulo

    String document = value.toString().replaceAll("[^0-9]", ""); // Remove qualquer caractere que não seja número


     /*  
            Verificando se o CPF ou CNPJ tem 11 ou 14 dígitos para saber qual tipo de documento será verificado.
            CPF: 11 números -> 9 dígitos + 2 dígitos verificadores
            CNPJ: 14 números -> 12 dígitos + 3 dígitos verificadores
            
            Se for um CPF tem que ter exatamente 11 e se for CNPJ precisa ser 14
    */

    if (document.length() == 11) {
        return isValidCPF(document);
    } else if (document.length() == 14) {
        return isValidCNPJ(document);
    }

    return false; // Retorna falso se não for CPF nem CNPJ
}


    /**
     * Checks if is valid CNPJ.
     *
     * @param document the document
     * @return true, if is valid CNPJ
     */
    private boolean isValidCNPJ(String document) {
        if (document.length() != 14 || !document.matches("\\d{14}")) return false;
        
         /*
            O CNPJ é formado por:
            6 números da empresa + 2 dígitos de verificação + 2 dígitos de verificação
        */

        // Verifica dígitos identificadores
        int soma = 0;
        int peso = 2;
        for (int i = 11; i >= 0; i--) {
            int num = Character.getNumericValue(document.charAt(i));
            soma += num * peso;
            peso = (peso == 9) ? 2 : peso + 1;
        }
        int dv1 = (soma % 11 == 0 || soma % 11 == 1) ? 0 : 11 - (soma % 11);
        if (dv1 != Character.getNumericValue(document.charAt(12))) return false;
    
        /*
            Se passou pela primeira parte, agora vamos calcular o segundo dígito de verificação.
            Para isso, invertemos os 12 primeiros dígitos e colocamos na mesma ordem que estão no documento,
            e calculamos o resto da divisão por 11. Se o resultado for zero, o último dígito deve ser zero,
            caso contrário deve ser o número correspondente ao restante da divisão por 11.
        */

        // Verifica segundo dígito identificador
        soma = 0;
        peso = 2;
        for (int i = 12; i >= 0; i--) {
            int num = Character.getNumericValue(document.charAt(i));
            soma += num * peso;
            peso = (peso == 9) ? 2 : peso + 1;
        }
        int dv2 = (soma % 11 == 0 || soma % 11 == 1) ? 0 : 11 - (soma % 11);
        return dv2 == Character.getNumericValue(document.charAt(13));
    }
    

    /**
     * Checks if is valid CPF.
     *
     * @param document the document
     * @return true, if is valid CPF
     */
    private boolean isValidCPF(String document) {
        // Verifica se o CPF tem 11 dígitos
        if (document.length() != 11) return false;
    
        // Calcula o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(document.charAt(i)) * (10 - i);
        }
        int primeiroDigito = 11 - (soma % 11);
        if (primeiroDigito >= 10) primeiroDigito = 0;
    
        // Verifica o primeiro dígito verificador
        if (Character.getNumericValue(document.charAt(9)) != primeiroDigito) return false;
    
        // Calcula o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(document.charAt(i)) * (11 - i);
        }
        int segundoDigito = 11 - (soma % 11);
        if (segundoDigito >= 10) segundoDigito = 0;
    
        // Verifica o segundo dígito verificador
        return Character.getNumericValue(document.charAt(10)) == segundoDigito;
    }
    
}
