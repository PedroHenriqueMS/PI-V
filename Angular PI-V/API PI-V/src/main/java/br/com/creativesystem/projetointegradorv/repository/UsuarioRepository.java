package br.com.creativesystem.projetointegradorv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.creativesystem.projetointegradorv.model.Usuario;


/**
 * The Interface UsuarioRepository.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
