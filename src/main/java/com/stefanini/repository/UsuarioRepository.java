package com.stefanini.repository;

import com.stefanini.dao.GenericDAO;
import com.stefanini.dto.UsuarioDTO;
import com.stefanini.model.Usuario;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped //Stateless
public class UsuarioRepository extends GenericDAO<Usuario, Long> {
    @Transactional
    public UsuarioDTO adicionaUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO);
        this.save(usuario);
        return new UsuarioDTO(usuario);
    }

    @Transactional
    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO);
        this.update(usuario);
        return new UsuarioDTO(usuario);
    }

    public List<Usuario> buscarAniversariantes(int mes) {
        Query nativeQuery = this.createNativeQuery("SELECT * FROM usuario WHERE month(data_nascimento) = ?");
        nativeQuery.setParameter(1, mes);
        List<Usuario> resultList = nativeQuery.getResultList();
        return resultList;
    }

    public List<Usuario> buscarPrimeiraLetra(String letra) {
        Query nativeQuery = this.createNativeQuery("SELECT * FROM usuario WHERE nome LIKE ?");
        nativeQuery.setParameter(1, letra + "%");
        List<Usuario> resultList = nativeQuery.getResultList();
        return resultList;
    }

    public List<String> listaProvedores(){
        return createQuery("SELECT DISTINCT SUBSTRING(email, LOCATE('@', email) + 1) AS provedores FROM Usuario ORDER BY provedores", String.class).getResultList();
    }

    //SELECT DISTINCT SUBSTRING_INDEX(email,'@',-1) AS provedor FROM usuario;
}

