package br.com.creativesystem.projetointegradoriv.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.creativesystem.projetointegradoriv.domain.Cliente;
import br.com.creativesystem.projetointegradoriv.service.ClienteService;

@RestController
@RequestMapping("/api/cs/clientes")
public class ClienteResource {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> clientePorId(@PathVariable("id") Long id) {
        Cliente cliente = clienteService.findOne(id);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Cliente>> lisarTodosClientes() {
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok().body(clientes);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente){
        clienteService.save(cliente);   
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> atualizarCliente (@PathVariable ("id") Long id, 
    @RequestBody Cliente cliente) {
        Cliente clienteOriginal = clienteService.findOne(id);
        clienteOriginal.setClienteNome(cliente.getClienteNome());
        clienteOriginal.setClienteCpf(cliente.getClienteCpf());
        clienteOriginal.setClienteFone(cliente.getClienteFone());
        clienteService.update(clienteOriginal);
        return ResponseEntity.status(HttpStatus.OK).body(clienteOriginal);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable ("id") Long id) {
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}