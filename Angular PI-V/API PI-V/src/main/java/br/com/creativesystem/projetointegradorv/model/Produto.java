package br.com.creativesystem.projetointegradorv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Produto.
 */
@Entity
@Table(name = "tb_produto")
public class Produto {
    
    /** The produto id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long produtoId;
    
    /** The produto nome. */
    @Column(name = "nome")
    private String produtoNome;
    
    /** The produto descricao. */
    @Column(name = "descricao")
    private String produtoDescricao;
    
    /** The produto preco. */
    @Column(name = "preco")
    private Double produtoPreco;
    
    /**
     * Instantiates a new produto.
     *
     * @param produtoNome the produto nome
     * @param produtoDescricao the produto descricao
     * @param produtoPreco the produto preco
     */
    public Produto(String produtoNome, String produtoDescricao, Double produtoPreco) {
        this.produtoNome = produtoNome;
        this.produtoDescricao = produtoDescricao;
        this.produtoPreco = produtoPreco;
    }

    /**
     * Instantiates a new produto.
     */
    public Produto() {
        //TODO Auto-generated constructor stub
    }

    /**
     * Gets the produto id.
     *
     * @return the produto id
     */
    public Long getProdutoId() {
        return produtoId;
    }

    /**
     * Sets the produto id.
     *
     * @param produtoId the new produto id
     */
    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    /**
     * Gets the produto nome.
     *
     * @return the produto nome
     */
    public String getProdutoNome() {
        return produtoNome;
    }

    /**
     * Sets the produto nome.
     *
     * @param produtoNome the new produto nome
     */
    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    /**
     * Gets the produto descricao.
     *
     * @return the produto descricao
     */
    public String getProdutoDescricao() {
        return produtoDescricao;
    }

    /**
     * Sets the produto descricao.
     *
     * @param produtoDescricao the new produto descricao
     */
    public void setProdutoDescricao(String produtoDescricao) {
        this.produtoDescricao = produtoDescricao;
    }

    /**
     * Gets the produto preco.
     *
     * @return the produto preco
     */
    public Double getProdutoPreco() {
        return produtoPreco;
    }

    /**
     * Sets the produto preco.
     *
     * @param produtoPreco the new produto preco
     */
    public void setProdutoPreco(Double produtoPreco) {
        this.produtoPreco = produtoPreco;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Produto [produtoId=" + produtoId + ", produtoNome=" + produtoNome + ", produtoDescricao="
                + produtoDescricao + ", produtoPreco=" + produtoPreco + "]";
    }
}
