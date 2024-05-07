package br.com.creativesystem.projetointegradorv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.creativesystem.projetointegradorv.error.NotFoundException;
import br.com.creativesystem.projetointegradorv.model.Usuario;
import br.com.creativesystem.projetointegradorv.repository.UsuarioRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioService.
 */
@Service
public class UsuarioService {

    /** The usuario repository. */
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Find one.
     *
     * @param id the id
     * @return the usuario
     */
    public Usuario findOne(Long id) {
        return usuarioRepository.findById(id).orElseThrow( () -> new NotFoundException("Usuário com o id = " + id + " não encontrado"));
    }

    /**
     * Find all.
     *
     * @return the list
     */
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    /**
     * Save.
     *
     * @param usuario the usuario
     * @return the usuario
     */
    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    public void deleteById(Long id) {

        if(!usuarioRepository.existsById(id)){
            throw new NotFoundException("Usuario não encontrado: id="+id);
        }

        usuarioRepository.deleteById(id);
    }

    /**
     * Update.
     *
     * @param usuario the usuario
     */
    public void update(Usuario usuario) {

        if(!usuarioRepository.existsById(usuario.getUserId())){
            throw new NotFoundException("Usuario não encontrado: id="+usuario.getUserId());
        }

        usuarioRepository.saveAndFlush(usuario);
    }

    /**
     * Find by nome.
     *
     * @param nome the nome
     * @return the list
     */
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
