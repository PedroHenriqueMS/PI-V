package br.com.creativesystem.projetointegradoriv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.creativesystem.projetointegradoriv.domain.Cliente;
import br.com.creativesystem.projetointegradoriv.error.NotFoundException;
import br.com.creativesystem.projetointegradoriv.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findOne(Long id) {
        return clienteRepository.findById(id).orElseThrow( () -> new NotFoundException("Cliente com o id = " + id + " não encontrado"));
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public void save(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public void deleteById(Long id) {

        if(!clienteRepository.existsById(id)){
            throw new NotFoundException("Cliente não encontrado: id="+id);
        }

        clienteRepository.deleteById(id);
    }

    public void update(Cliente cliente) {

        if(!clienteRepository.existsById(cliente.getClienteId())){
            throw new NotFoundException("Cliente não encontrado: id="+cliente.getClienteId());
        }

        clienteRepository.saveAndFlush(cliente);
    }
    
}
