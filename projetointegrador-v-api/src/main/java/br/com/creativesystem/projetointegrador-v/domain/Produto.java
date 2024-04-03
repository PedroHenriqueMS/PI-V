package br.com.creativesystem.projetointegradoriv.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long produtoId;
    private String produtoNome;
    private String produtoDescricao;
    private Double produtoPreco;
    
    public Produto(String produtoNome, String produtoDescricao, Double produtoPreco) {
        this.produtoNome = produtoNome;
        this.produtoDescricao = produtoDescricao;
        this.produtoPreco = produtoPreco;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public String getProdutoDescricao() {
        return produtoDescricao;
    }

    public void setProdutoDescricao(String produtoDescricao) {
        this.produtoDescricao = produtoDescricao;
    }

    public Double getProdutoPreco() {
        return produtoPreco;
    }

    public void setProdutoPreco(Double produtoPreco) {
        this.produtoPreco = produtoPreco;
    }

    @Override
    public String toString() {
        return "Produto [produtoId=" + produtoId + ", produtoNome=" + produtoNome + ", produtoDescricao="
                + produtoDescricao + ", produtoPreco=" + produtoPreco + "]";
    }
}
