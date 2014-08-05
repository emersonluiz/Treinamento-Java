package br.com.dao;

import java.util.List;

public interface Persistence<T> {

	public T insert(T element);
	public T update(T element);
	public T delete(int id);
	public T get(int id);
	public List<T> getAll();
	
}
