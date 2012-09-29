package com.herokuapp.portalbll.daos.impl;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.herokuapp.portalbll.daos.UsuarioDAO;
import com.herokuapp.portalbll.entities.Usuario;

@Repository("usuarioDAO")
public class UsuarioDAOImpl extends AbstractDAOImpl<Usuario> implements UsuarioDAO<Usuario>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;

	public UsuarioDAOImpl() {
		super(Usuario.class);
	}

	@Override
	public EntityManager getEntityManager() {

		if (em == null) {
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("portalbllPU");
			em = emf.createEntityManager();
		}
		return em;
	}
	
	public Usuario findByLogin(String login){
		Query q = em.createNamedQuery("Usuario.findByLogin");
		q.setParameter("login", login);
		Usuario usuario = null;
		try{
			usuario = (Usuario)q.getSingleResult();
		}
		catch(NoResultException e){
			Logger.getAnonymousLogger().info("Não encontrou o login.");
		}
		
		return usuario;
	}

}
