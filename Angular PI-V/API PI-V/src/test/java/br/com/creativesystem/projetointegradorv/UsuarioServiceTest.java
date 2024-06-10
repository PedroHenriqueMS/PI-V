package br.com.creativesystem.projetointegradorv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.creativesystem.projetointegradorv.error.NotFoundException;
import br.com.creativesystem.projetointegradorv.model.Usuario;
import br.com.creativesystem.projetointegradorv.repository.UsuarioRepository;
import br.com.creativesystem.projetointegradorv.service.UsuarioService;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioServiceTest.
 */
@SpringBootTest
public class UsuarioServiceTest {

    /** The usuario service. */
    @Autowired
    private UsuarioService usuarioService;

    /** The usuario repository. */
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Sets the up.
     */
    @BeforeEach
    public void setUp() {

        // Configurar os dados de teste antes de cada execução de teste
        Usuario usuario = new Usuario("Usuario Teste", "usuario@teste.com", "senha123");
        usuarioRepository.save(usuario);
    }

    /**
     * Test find one.
     */
    @Test
    public void testFindOne() {
        Long id = 1L;
        Usuario usuario = new Usuario("Usuario Teste", "usuario@teste.com", "senha123");
        usuario.setUserId(id);

        Usuario foundUsuario = usuarioService.findOne(id);

        assertNotNull(foundUsuario);
        assertEquals(id, foundUsuario.getUserId());
        assertEquals("Usuario Teste", foundUsuario.getUserNome());
    }

    /**
     * Test find one not found.
     */
    @Test
    public void testFindOneNotFound() {
        Long id = 10L;

        assertThrows(NotFoundException.class, () -> usuarioService.findOne(id));
    }

    /**
     * Test find all.
     */
    @Test
    public void testFindAll() {
        List<Usuario> usuarios = List.of(
                new Usuario("Usuario Teste 1", "usuario1@teste.com", "senha123"),
                new Usuario("Usuario Teste 2", "usuario2@teste.com", "senha456"));
        usuarioRepository.saveAll(usuarios);

        List<Usuario> foundUsuarios = usuarioService.findAll();

        assertNotNull(foundUsuarios);
        assertEquals(4, foundUsuarios.size()); // Deve ser 4 pois já existe dois usuário configurado no setUp
    }

    /**
     * Test save.
     */
    @Test
    public void testSave() {
        Usuario usuario = new Usuario("Novo Usuário", "novo@usuario.com", "senha456");

        Usuario savedUsuario = usuarioService.save(usuario);

        assertNotNull(savedUsuario);
        assertNotNull(savedUsuario.getUserId()); // Verifica se o ID foi gerado
        assertEquals("Novo Usuário", savedUsuario.getUserNome());
    }

    /**
     * Test delete by id.
     */
    @Test
    public void testDeleteById() {
        // Configurar o banco de dados com um usuário a ser excluído
        Usuario usuario = new Usuario("Usuario Excluir", "excluir@usuario.com", "senha789");
        usuarioRepository.save(usuario);

        Long id = usuario.getUserId();

        // Testar a exclusão do usuário por ID
        usuarioService.deleteById(id);

        // Verificar se o usuário foi excluído corretamente
        Optional<Usuario> deletedUsuario = usuarioRepository.findById(id);
        assertEquals(Optional.empty(), deletedUsuario);
    }

    /**
     * Test update.
     */
    @Test
    public void testUpdate() {
        // Configurar o banco de dados com um usuário a ser atualizado
        Usuario usuario = new Usuario("Usuario Antigo", "antigo@usuario.com", "senha123");
        usuarioRepository.save(usuario);

        Long id = usuario.getUserId();

        // Atualizar os dados do usuário
        Usuario usuarioAtualizado = new Usuario("Usuario Atualizado", "atualizado@usuario.com", "senha456");
        usuarioAtualizado.setUserId(id);

        // Testar a atualização do usuário
        usuarioService.update(usuarioAtualizado);

        // Verificar se os dados foram atualizados corretamente
        Optional<Usuario> updatedUsuario = usuarioRepository.findById(id);
        assertEquals(usuarioAtualizado.getUserNome(), updatedUsuario.get().getUserNome());
        assertEquals(usuarioAtualizado.getUserEmail(), updatedUsuario.get().getUserEmail());
    }
}
