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

import br.com.creativesystem.projetointegradoriv.domain.Produto;
import br.com.creativesystem.projetointegradoriv.service.ProdutoService;



@RestController
@RequestMapping("/api/cs/produtos")
public class ProdutoResource {
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> produtoPorId(@PathVariable("id") Long id) {
        Produto produto = produtoService.findOne(id);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Produto>> lisarTodosProdutos() {
        List<Produto> produtos = produtoService.findAll();
        return ResponseEntity.ok().body(produtos);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto){
        produtoService.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> atualizarProduto(@PathVariable ("id") Long id, 
    @RequestBody Produto produto) {
        Produto produtoOriginal = produtoService.findOne(id);
        produtoOriginal.setProdutoNome(produto.getProdutoNome());
        produtoOriginal.setProdutoDescricao(produto.getProdutoDescricao());
        produtoOriginal.setProdutoPreco(produto.getProdutoPreco());
        produtoService.update(produtoOriginal);
        return ResponseEntity.status(HttpStatus.OK).body(produtoOriginal);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable ("id") Long id) {
        produtoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}