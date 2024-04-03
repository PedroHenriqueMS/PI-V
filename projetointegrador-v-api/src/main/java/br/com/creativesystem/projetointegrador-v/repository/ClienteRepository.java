package br.com.creativesystem.projetointegradoriv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.creativesystem.projetointegradoriv.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}