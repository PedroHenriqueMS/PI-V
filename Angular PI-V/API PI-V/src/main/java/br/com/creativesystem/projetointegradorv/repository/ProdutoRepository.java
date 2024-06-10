package br.com.creativesystem.projetointegradorv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.creativesystem.projetointegradorv.model.Produto;


/**
 * The Interface ProdutoRepository.
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    
}
