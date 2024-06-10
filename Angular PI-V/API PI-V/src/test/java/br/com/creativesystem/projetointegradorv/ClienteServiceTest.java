package br.com.creativesystem.projetointegradorv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.creativesystem.projetointegradorv.error.NotFoundException;
import br.com.creativesystem.projetointegradorv.model.Cliente;
import br.com.creativesystem.projetointegradorv.repository.ClienteRepository;
import br.com.creativesystem.projetointegradorv.service.ClienteService;

// TODO: Auto-generated Javadoc
/**
 * The Class ClienteServiceTest.
 */
@SpringBootTest
public class ClienteServiceTest {

    /** The cliente service. */
    @Autowired
    private ClienteService clienteService;

    /** The cliente repository. */
    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Sets the up.
     */
    @BeforeEach
    public void setUp() {

        // Configurar os dados de teste antes de cada execução de teste
        Cliente cliente = new Cliente();
        cliente.setClienteNome("Cliente Teste");
        cliente.setClienteCpf("009.030.771-24");
        cliente.setClienteFone("(62)00000-0000");
        clienteRepository.save(cliente);
    }

    /**
     * Test save.
     */
    @Test
    public void testSave() {
        Cliente cliente = new Cliente("Cliente Teste", "009.030.771-24", "(11)1234-5678");

        Cliente savedCliente = clienteService.save(cliente);

        assertNotNull(savedCliente);
        assertEquals("Cliente Teste", savedCliente.getClienteNome());
    }

    /**
     * Test find one.
     */
    @Test
    public void testFindOne() {
        Long id = 1L;
        Cliente cliente = new Cliente("Cliente Teste", "12345678901", "(11)1234-5678");
        cliente.setClienteId(id);

        Cliente foundCliente = clienteService.findOne(id);

        assertNotNull(foundCliente);
        assertEquals(id, foundCliente.getClienteId());
        assertEquals("Cliente Teste", foundCliente.getClienteNome());
    }

    /**
     * Test find one not found.
     */
    @Test
    public void testFindOneNotFound() {
        Long id = 10L;

        assertThrows(NotFoundException.class, () -> clienteService.findOne(id));
    }

    /**
     * Test find all.
     */
    @Test
    public void testFindAll() {
        List<Cliente> clientes = List.of(
            new Cliente("Cliente Teste 1", "009.030.771-24", "(11)1234-5678"),
            new Cliente("Cliente Teste 2", "009.030.771-24", "(11)9876-5432")
        );
        clienteRepository.saveAll(clientes);

        List<Cliente> foundClientes = clienteService.findAll();

        assertNotNull(foundClientes);
        assertEquals(4, foundClientes.size()); // Deve ser 4 pois já existe dois cliente configurado no setUp
    }

    /**
     * Test delete by id.
     */
    @Test
    public void testDeleteById() {
        Long id = 1L;
        clienteService.deleteById(id);
        assertFalse(clienteRepository.existsById(id));
    }

    /**
     * Test update.
     */
    @Test
    public void testUpdate() {
        Cliente cliente = new Cliente("Cliente antigo", "009.030.771-24", "(11)1234-5678");
        clienteRepository.save(cliente);
        
        Long id = cliente.getClienteId();
        
        Cliente clienteAtualizado = new Cliente("Cliente Atualizado", "009.030.771-24", "(11)1234-5678");

        clienteAtualizado.setClienteId(id);

        clienteService.update(clienteAtualizado);

        Cliente updatedCliente = clienteRepository.findById(id).orElseThrow();
        assertEquals("Cliente Atualizado", updatedCliente.getClienteNome());
    }

}
