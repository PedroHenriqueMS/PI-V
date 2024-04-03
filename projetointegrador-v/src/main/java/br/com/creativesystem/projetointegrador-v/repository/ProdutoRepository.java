package br.com.creativesystem.projetointegradoriv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.creativesystem.projetointegradoriv.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    
}
