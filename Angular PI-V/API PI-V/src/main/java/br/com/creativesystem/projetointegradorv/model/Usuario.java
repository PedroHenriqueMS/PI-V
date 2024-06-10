package br.com.creativesystem.projetointegradorv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Usuario.
 */
@Entity
@Table(name = "tb_usuario")
public class Usuario {

    /** The user id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;
    
    /** The user nome. */
    @Column(name = "nome")
    private String userNome;
    
    /** The user email. */
    @Column(name = "email")
    private String userEmail;
    
    /** The user senha. */
    @Column(name = "senha")
    private String userSenha;
    
    /**
     * Instantiates a new usuario.
     *
     * @param userNome the user nome
     * @param userEmail the user email
     * @param userSenha the user senha
     */
    public Usuario(String userNome, String userEmail, String userSenha) {
        this.userNome = userNome;
        this.userEmail = userEmail;
        this.userSenha = userSenha;
    }

    /**
     * Instantiates a new usuario.
     */
    public Usuario() {
    }

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId the new user id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the user nome.
     *
     * @return the user nome
     */
    public String getUserNome() {
        return userNome;
    }

    /**
     * Sets the user nome.
     *
     * @param userNome the new user nome
     */
    public void setUserNome(String userNome) {
        this.userNome = userNome;
    }

    /**
     * Gets the user email.
     *
     * @return the user email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Sets the user email.
     *
     * @param userEmail the new user email
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Gets the user senha.
     *
     * @return the user senha
     */
    public String getUserSenha() {
        return userSenha;
    }

    /**
     * Sets the user senha.
     *
     * @param userSenha the new user senha
     */
    public void setUserSenha(String userSenha) {
        this.userSenha = userSenha;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Usuario [userId=" + userId + ", userNome=" + userNome + ", userEmail=" + userEmail + ", userSenha="
                + userSenha + "]";
    }

    /**
     * Checks if is empty.
     *
     * @return true, if is empty
     */
    public boolean isEmpty() {
        return false;
    }
    
}
