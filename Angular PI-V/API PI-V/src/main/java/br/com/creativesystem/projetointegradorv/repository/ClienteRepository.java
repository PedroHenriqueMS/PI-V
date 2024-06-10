package br.com.creativesystem.projetointegradorv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.creativesystem.projetointegradorv.model.Cliente;


// TODO: Auto-generated Javadoc
/**
 * The Interface ClienteRepository.
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    /**
     * Find by name.
     *
     * @param clienteNome the cliente nome
     * @return the cliente
     */
    Cliente findByClienteNome(String clienteNome);
    
    /**
     * Find by cpf.
     *
     * @param clienteCpf the cliente cpf
     * @return the cliente
     */
    Cliente findByClienteCpf(String clienteCpf);
}
