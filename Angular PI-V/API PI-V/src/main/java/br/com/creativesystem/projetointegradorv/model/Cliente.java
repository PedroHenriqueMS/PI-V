package br.com.creativesystem.projetointegradorv.model;

import br.com.creativesystem.projetointegradorv.annotations.CpfCnpjAnnotation;
import br.com.creativesystem.projetointegradorv.validator.CpfCnpjConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

// TODO: Auto-generated Javadoc
/**
 * The Class Cliente.
 */
@Entity
@Table(name = "tb_cliente")
public class Cliente {
    
    /** The cliente id. */
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private Long clienteId;
    
    /** The cliente nome. */
    //@NotBlank(message="Nome é obrigatório.")
    @Column(name = "nome")
    private String clienteNome;
    
    /** The cliente cpf. */
    //@NotBlank(message="CPF/CNPJ é obrigatório.")
    //@CpfCnpjAnnotation
    //@Convert(converter = CpfCnpjConverter.class)
    @Column(name = "cpf_cnpj")
    private String clienteCpf;
    
    /** The cliente fone. */
    //@NotBlank
    //@Pattern(regexp = "^\\(\\d{2}\\)\\d{4,5}-\\d{4}$", message = "O telefone deve estar no formato (DD)XXXX-XXXX")
    @Column(name = "telefone")
    private String clienteFone;
    
    /**
     * Instantiates a new cliente.
     */
    public Cliente() {
    }

    /**
     * Instantiates a new cliente.
     *
     * @param clienteNome the cliente nome
     * @param clienteCpfCnpj the cliente cpf cnpj
     * @param clienteFone the cliente fone
     */
    public Cliente(String clienteNome, String clienteCpfCnpj, String clienteFone) {
        this.clienteNome = clienteNome;
        this.clienteCpf = clienteCpfCnpj;
        this.clienteFone = clienteFone;
    }

    /**
     * Gets the cliente id.
     *
     * @return the cliente id
     */
    public Long getClienteId() {
        return clienteId;
    }

    /**
     * Sets the cliente id.
     *
     * @param clienteId the new cliente id
     */
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    /**
     * Gets the cliente nome.
     *
     * @return the cliente nome
     */
    public String getClienteNome() {
        return clienteNome;
    }

    /**
     * Sets the cliente nome.
     *
     * @param clienteNome the new cliente nome
     */
    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    /**
     * Gets the cliente cpf.
     *
     * @return the cliente cpf
     */
    public String getClienteCpf() {
        return clienteCpf;
    }

    /**
     * Sets the cliente cpf.
     *
     * @param clienteCpf the new cliente cpf
     */
    public void setClienteCpf(String clienteCpf) {
        this.clienteCpf = clienteCpf;
    }

    /**
     * Gets the cliente fone.
     *
     * @return the cliente fone
     */
    public String getClienteFone() {
        return clienteFone;
    }

    /**
     * Sets the cliente fone.
     *
     * @param clienteFone the new cliente fone
     */
    public void setClienteFone(String clienteFone) {
        this.clienteFone = clienteFone;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Cliente [clienteId=" + clienteId + ", clienteNome=" + clienteNome + ", clienteCpfCnpj=" + clienteCpf
                + ", clienteFone=" + clienteFone + "]";
    }

    /**
     * Sets the email.
     *
     * @param string the new email
     */
    public void setEmail(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setEmail'");
    }
}

