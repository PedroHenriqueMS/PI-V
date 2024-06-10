package br.com.creativesystem.projetointegradorv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.creativesystem.projetointegradorv.error.NotFoundException;
import br.com.creativesystem.projetointegradorv.model.Cliente;
import br.com.creativesystem.projetointegradorv.repository.ClienteRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ClienteService.
 */
@Service
public class ClienteService {

    /** The cliente repository. */
    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Find one.
     *
     * @param id the id
     * @return the cliente
     */
    public Cliente findOne(Long id) {
        return clienteRepository.findById(id).orElseThrow( () -> new NotFoundException("Cliente com o id = " + id + " não encontrado"));
    }

    /**
     * Find all.
     *
     * @return the list
     */
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    /**
     * Save.
     *
     * @param cliente the cliente
     * @return the cliente
     */
    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    public void deleteById(Long id) {

        if(!clienteRepository.existsById(id)){
            throw new NotFoundException("Cliente não encontrado: id="+id);
        }

        clienteRepository.deleteById(id);
    }

    /**
     * Update.
     *
     * @param cliente the cliente
     */
    public void update(Cliente cliente) {

        if(!clienteRepository.existsById(cliente.getClienteId())){
            throw new NotFoundException("Cliente não encontrado: id="+cliente.getClienteId());
        }

        clienteRepository.saveAndFlush(cliente);
    }
    
}

