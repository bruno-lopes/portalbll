package com.herokuapp.portalbll.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import com.herokuapp.portalbll.daos.AbstractDAO;

/**
 * DAO genérico com as operações básicas de todos os DAOs
 * 
 * @author bruno
 * 
 * @param <T>
 */
public abstract class AbstractDAOImpl<T> implements AbstractDAO<T>{

	private Class<T> entityClass;

	public AbstractDAOImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public void insert(T entity) {
		getEntityManager().persist(entity);
	}

	public void remove(T entity) {
		getEntityManager().remove(entity);
	}

	public void removeByID(Long id) {
		T entity = find(id);
		remove(entity);
	}

	public List<T> listAll() {
		CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder()
				.createQuery(entityClass);
		cq.select(cq.from(entityClass));
		return getEntityManager().createQuery(cq).getResultList();
	}

	public T find(Long id) {
		return getEntityManager().find(entityClass, id);
	}

	public abstract EntityManager getEntityManager();

}
