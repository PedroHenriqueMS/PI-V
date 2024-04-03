package br.com.creativesystem.projetointegradoriv.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userNome;
    private String userEmail;
    private String userSenha;
    
    public Usuario(String userNome, String userEmail, String userSenha) {
        this.userNome = userNome;
        this.userEmail = userEmail;
        this.userSenha = userSenha;
    }

    public Usuario() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserNome() {
        return userNome;
    }

    public void setUserNome(String userNome) {
        this.userNome = userNome;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserSenha() {
        return userSenha;
    }

    public void setUserSenha(String userSenha) {
        this.userSenha = userSenha;
    }

    @Override
    public String toString() {
        return "Usuario [userId=" + userId + ", userNome=" + userNome + ", userEmail=" + userEmail + ", userSenha="
                + userSenha + "]";
    }

    public boolean isEmpty() {
        return false;
    }
    
}
