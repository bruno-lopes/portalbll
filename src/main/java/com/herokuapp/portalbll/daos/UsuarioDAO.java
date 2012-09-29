package com.herokuapp.portalbll.daos;

import com.herokuapp.portalbll.entities.Usuario;


public interface UsuarioDAO<T> extends AbstractDAO<T>{

	public Usuario findByLogin(String login);

}
