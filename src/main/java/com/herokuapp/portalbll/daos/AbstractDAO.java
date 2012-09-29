package com.herokuapp.portalbll.daos;

import java.util.List;

import javax.persistence.EntityManager;

public interface AbstractDAO<T> {

	public void insert(T entity);

	public void remove(T entity);

	public void removeByID(Long id);

	public List<T> listAll();

	public T find(Long id);

	public abstract EntityManager getEntityManager();

}
