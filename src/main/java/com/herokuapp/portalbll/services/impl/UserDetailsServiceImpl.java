package com.herokuapp.portalbll.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.herokuapp.portalbll.daos.UsuarioDAO;
import com.herokuapp.portalbll.entities.Permissao;
import com.herokuapp.portalbll.entities.Usuario;

/**
 *
 * @author bruno
 */

public class UserDetailsServiceImpl implements UserDetailsService, Serializable{
    
    @Autowired
    //@Resource(name="usuarioDAO")
    private UsuarioDAO<Usuario> usuarioDAO;
    
    
   
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
    	Usuario usuario = null;
    	try{
    		usuario = usuarioDAO.findByLogin(username);
    	}
    	catch(Exception e ){
    		throw new UsernameNotFoundException("User not found: " + username);
    	}    	
        //AppUser user = userDao.findUser(username);
        if (usuario == null)
            throw new UsernameNotFoundException("User not found: " + username);
        else {
            return makeUser(usuario);
        }
    }

    private org.springframework.security.core.userdetails.User makeUser(Usuario user) {
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user
                .getPassword(), true, true, true, true,
                makeGrantedAuthorities(user));
    }

    private Collection<GrantedAuthority> makeGrantedAuthorities(Usuario user) {
    	Collection<GrantedAuthority> result = new ArrayList<GrantedAuthority>();//GrantedAuthority[user.getPermissoes().size()];
        for (Permissao role : user.getPermissoes()) {
        	result.add(new GrantedAuthorityImpl(role.getTipoPermissao().getNomeTipoPermissao()));
        }
        return result;
    }


}
