package br.com.creativesystem.projetointegradoriv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.creativesystem.projetointegradoriv.domain.Produto;
import br.com.creativesystem.projetointegradoriv.error.NotFoundException;
import br.com.creativesystem.projetointegradoriv.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findOne(Long id) {
        return produtoRepository.findById(id).orElseThrow( () -> new NotFoundException("Cliente com o id = " + id + " não encontrado"));
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public void save(Produto produto){
        produtoRepository.save(produto);
    }

    public void deleteById(Long id) {

        if(!produtoRepository.existsById(id)){
            throw new NotFoundException("Produto não encontrado: id="+id);
        }

        produtoRepository.deleteById(id);
    }

    public void update(Produto produto) {

        if(!produtoRepository.existsById(produto.getProdutoId())){
            throw new NotFoundException("Produto não encontrado: id="+produto.getProdutoId());
        }

        produtoRepository.saveAndFlush(produto);
    }
    
}
