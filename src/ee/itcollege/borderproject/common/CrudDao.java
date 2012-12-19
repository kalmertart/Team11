package ee.itcollege.borderproject.common;

import java.util.List;

public interface CrudDao<T> {

	List<T> getAll();

	void save(T entity) ;
	
	T find(Integer id);
	
	void update(T entity);
	
	void delete(Integer id);
	
}
