package br.com.creativesystem.projetointegradorv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.creativesystem.projetointegradorv.error.NotFoundException;
import br.com.creativesystem.projetointegradorv.model.Produto;
import br.com.creativesystem.projetointegradorv.repository.ProdutoRepository;
import br.com.creativesystem.projetointegradorv.service.ProdutoService;

// TODO: Auto-generated Javadoc
/**
 * The Class ProdutoServiceTest.
 */
@SpringBootTest
public class ProdutoServiceTest {

    /** The produto service. */
    @Autowired
    private ProdutoService produtoService;

    /** The produto repository. */
    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Sets the up.
     */
    @BeforeEach
    public void setUp() {

        // Configurar os dados de teste antes de cada execução de teste
        Produto produto = new Produto();
        produto.setProdutoNome("Produto Teste");
        produto.setProdutoDescricao("Testando produto");
        produto.setProdutoPreco(10.00);
        produtoRepository.save(produto);
    }

    /**
     * Test save.
     */
    @Test
    public void testSave() {
        Produto produto = new Produto("Produto Teste", "Descrição do Produto", 100.0);

        Produto savedProduto = produtoService.save(produto);

        assertNotNull(savedProduto);
        assertEquals("Produto Teste", savedProduto.getProdutoNome());
    }

    /**
     * Test find one.
     */
    @Test
    public void testFindOne() {
        Long id = 1L;
        Produto produto = new Produto("Produto Teste", "Descrição do Produto", 100.0);
        produto.setProdutoId(id);

        Produto foundProduto = produtoService.findOne(id);

        assertNotNull(foundProduto);
        assertEquals(id, foundProduto.getProdutoId());
        assertEquals("Produto Teste", foundProduto.getProdutoNome());
    }

    /**
     * Test find one not found.
     */
    @Test
    public void testFindOneNotFound() {
        Long id = 10L;

        assertThrows(NotFoundException.class, () -> produtoService.findOne(id));
    }

    /**
     * Test find all.
     */
    @Test
    public void testFindAll() {
        List<Produto> produtos = List.of(
            new Produto("Produto Teste 1", "Descrição do Produto 1", 100.0),
            new Produto("Produto Teste 2", "Descrição do Produto 2", 200.0)
        );
        produtoRepository.saveAll(produtos);

        List<Produto> foundProdutos = produtoService.findAll();

        assertNotNull(foundProdutos);
        assertEquals(4, foundProdutos.size()); // Deve ser 4 pois já existe dois produto configurado no setUp
    }


    /**
     * Test delete by id.
     */
    @Test
    public void testDeleteById() {
        Long id = 1L;
        produtoService.deleteById(id);
        assertFalse(produtoRepository.existsById(id));
    }

    /**
     * Test update.
     */
    @Test
    public void testUpdate() {
        // Configurar o banco de dados com um produto a ser atualizado
        Produto produto = new Produto("Produto Antigo", "Descricao antiga", 10.00);
        produtoRepository.save(produto);

        Long id = produto.getProdutoId();

        // Atualizar os dados do usuário
        Produto produtoAtualizado = new Produto("Produto Atualizado", "Descricao atualizada", 20.00);
        produtoAtualizado.setProdutoId(id);

        // Testar a atualização do usuário
        produtoService.update(produtoAtualizado);

        // Verificar se os dados foram atualizados corretamente
        Optional<Produto> updatedproduto = produtoRepository.findById(id);
        assertEquals(produtoAtualizado.getProdutoNome(), updatedproduto.get().getProdutoNome());
        assertEquals(produtoAtualizado.getProdutoDescricao(), updatedproduto.get().getProdutoDescricao());
    }

}
