package dao;

import java.util.List;

public interface IDao<T> {

	public T save(T o);
	
	public List<T> selectAll();
	
	public T update(T o);

	public List<T> selectAll(String sortField, String sort);

	public T getById(Long id);

	public void remove(Long id);

	public T findOne(String paramName, Object paramValue);

	public int findCountBy(String paramName, String paramValue);
}
