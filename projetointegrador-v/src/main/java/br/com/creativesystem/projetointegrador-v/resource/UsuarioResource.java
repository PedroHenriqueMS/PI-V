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

import br.com.creativesystem.projetointegradoriv.domain.Usuario;
import br.com.creativesystem.projetointegradoriv.service.UsuarioService;


@RestController
@RequestMapping("/api/cs/usuarios")
public class UsuarioResource {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> usuarioPorId(@PathVariable("id") Long id) {
        Usuario usuario = usuarioService.findOne(id);
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Usuario>> lisarTodosUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok().body(usuarios);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
        usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);  
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable ("id") Long id, 
    @RequestBody Usuario usuario) {
        Usuario usuarioOriginal = usuarioService.findOne(id);
        usuarioOriginal.setUserNome(usuario.getUserNome());
        usuarioOriginal.setUserEmail(usuario.getUserEmail());
        usuarioOriginal.setUserSenha(usuario.getUserSenha());
        usuarioService.update(usuarioOriginal);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioOriginal);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable ("id") Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<List<Usuario>> usuariosPorNome(@PathVariable("nome") String nome) {
        List<Usuario> usuarios = usuarioService.findByNome(nome);

        if (usuarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(usuarios);
    }

}