package br.com.creativesystem.projetointegradorv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.creativesystem.projetointegradorv.error.NotFoundException;
import br.com.creativesystem.projetointegradorv.model.Produto;
import br.com.creativesystem.projetointegradorv.repository.ProdutoRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ProdutoService.
 */
@Service
public class ProdutoService {

    /** The produto repository. */
    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Find one.
     *
     * @param id the id
     * @return the produto
     */
    public Produto findOne(Long id) {
        return produtoRepository.findById(id).orElseThrow( () -> new NotFoundException("Cliente com o id = " + id + " não encontrado"));
    }

    /**
     * Find all.
     *
     * @return the list
     */
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    /**
     * Save.
     *
     * @param produto the produto
     * @return the produto
     */
    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    public void deleteById(Long id) {

        if(!produtoRepository.existsById(id)){
            throw new NotFoundException("Produto não encontrado: id="+id);
        }

        produtoRepository.deleteById(id);
    }

    /**
     * Update.
     *
     * @param produto the produto
     */
    public void update(Produto produto) {

        if(!produtoRepository.existsById(produto.getProdutoId())){
            throw new NotFoundException("Produto não encontrado: id="+produto.getProdutoId());
        }

        produtoRepository.saveAndFlush(produto);
    }
    
}

