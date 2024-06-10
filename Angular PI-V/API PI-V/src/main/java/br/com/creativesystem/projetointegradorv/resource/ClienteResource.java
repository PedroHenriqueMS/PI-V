package br.com.creativesystem.projetointegradorv.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.creativesystem.projetointegradorv.model.Cliente;
import br.com.creativesystem.projetointegradorv.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


// TODO: Auto-generated Javadoc
/**
 * The Class ClienteResource.
 */
@CrossOrigin
@RestController
@RequestMapping("/api/cs/clientes")
@Tag(name = "Swagger Documentation for Cliente API")
public class ClienteResource {
    
    /** The cliente service. */
    @Autowired
    private ClienteService clienteService;

    /**
     * Cliente por id.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> clientePorId(@PathVariable("id") Long id) {
        Cliente cliente = clienteService.findOne(id);
        return ResponseEntity.ok().body(cliente);
    }

    /**
     * Lisar todos clientes.
     *
     * @return the response entity
     */
    @Operation(summary = "Get All Clientes", method = "GET")
    @GetMapping
    public ResponseEntity<List<Cliente>> lisarTodosClientes() {
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok().body(clientes);
    }

    /**
     * Criar cliente.
     *
     * @param cliente the cliente
     * @return the response entity
     */
    @Operation(summary = "Add new Cliente", method = "Post")
    @ApiResponses(value = { 
            @ApiResponse(responseCode = "201", description = "Novo cliente adicionado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados da requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar inclusão"),
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente){
        clienteService.save(cliente);   
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    /**
     * Atualizar cliente.
     *
     * @param id the id
     * @param cliente the cliente
     * @return the response entity
     */
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

    /**
     * Deletar cliente.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable ("id") Long id) {
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
