package com.stefanini.service;

import com.stefanini.dto.UsuarioDTO;
import com.stefanini.model.Usuario;
import com.stefanini.repository.UsuarioRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarUsuarios(){
        List<Usuario> usuarios = usuarioRepository.listAll();
        return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public UsuarioDTO buscarPorId(Long id){
        return new UsuarioDTO(usuarioRepository.findById(id));
    }

    public UsuarioDTO adicionarUsuario(UsuarioDTO usuarioDTO) {
        String senha = Base64.getEncoder().encodeToString(usuarioDTO.getSenha().getBytes());
        usuarioDTO.setSenha(senha);
        return usuarioRepository.adicionaUsuario(usuarioDTO);
    }

    public UsuarioDTO atualizarUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id);
        usuario = new Usuario(usuarioDTO);
        return usuarioRepository.atualizarUsuario(usuarioDTO);
    }

    public void deletarUsuario(Long id){
        usuarioRepository.delete(id);
    }

    public List<UsuarioDTO> buscarAniversariantes(int mes) {
        List<Usuario> aniversariantes = usuarioRepository.buscarAniversariantes(mes);
        return aniversariantes.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public List<UsuarioDTO> buscarPrimeiraLetra(String letra) {
        List<Usuario> inicialNome = usuarioRepository.buscarPrimeiraLetra(letra);
        return inicialNome.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public List<String> listarProvedores() {
        return usuarioRepository.listaProvedores();
    }
}
