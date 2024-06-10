package br.com.creativesystem.projetointegradorv.validator;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;

// TODO: Auto-generated Javadoc
/**
 * The Class CpfCnpjConverter.
 */
@Convert
public class CpfCnpjConverter implements AttributeConverter<String, String> {

    /**
     * Convert to database column.
     *
     * @param attribute the attribute
     * @return the string
     */
    @Override
    public String convertToDatabaseColumn(String attribute) {
        // Remove caracteres não numéricos antes de persistir no banco de dados
        if (attribute == null) {
            return null;
        }
        return attribute.replaceAll("[^\\p{Alnum}]", "");
    }

    /**
     * Convert to entity attribute.
     *
     * @param dbData the db data
     * @return the string
     */
    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData; // Não há necessidade de modificar os dados ao serem lidos do banco de dados
    }
}
