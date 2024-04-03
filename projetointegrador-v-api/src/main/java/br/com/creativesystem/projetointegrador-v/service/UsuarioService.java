package br.com.creativesystem.projetointegradoriv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.creativesystem.projetointegradoriv.domain.Usuario;
import br.com.creativesystem.projetointegradoriv.error.NotFoundException;
import br.com.creativesystem.projetointegradoriv.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findOne(Long id) {
        return usuarioRepository.findById(id).orElseThrow( () -> new NotFoundException("Usuário com o id = " + id + " não encontrado"));
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {

        if(!usuarioRepository.existsById(id)){
            throw new NotFoundException("Usuario não encontrado: id="+id);
        }

        usuarioRepository.deleteById(id);
    }

    public void update(Usuario usuario) {

        if(!usuarioRepository.existsById(usuario.getUserId())){
            throw new NotFoundException("Usuario não encontrado: id="+usuario.getUserId());
        }

        usuarioRepository.saveAndFlush(usuario);
    }

    public List<Usuario> findByNome(String nome) {
    List<Usuario> usuariosEncontrados = new ArrayList<>();
    for (Usuario u : usuarioRepository.findAll()) {
        if (u.getUserNome().equalsIgnoreCase(nome)) {
            usuariosEncontrados.add(u);
        }
    }
    return usuariosEncontrados;
}

}
