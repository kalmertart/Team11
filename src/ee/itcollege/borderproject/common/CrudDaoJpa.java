package ee.itcollege.borderproject.common;

import java.lang.reflect.ParameterizedType;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.security.core.context.SecurityContextHolder;

public abstract class CrudDaoJpa<T extends BaseEntity> {
	
	protected EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("Team11BorderDb");
	
	
	private Class<T> entityClass = figureOutPersistentClass();
    
	public void save(T entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public T find(Integer id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			return em.find(entityClass, id);
		} 
		finally {
			em.close();
		}
	}

	public void update(T entity) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} 
		finally {
			em.close();
		}
	}

	public void delete(Integer id) {
		T entity = find(id);
		entity.setRemoved(new Date());
		entity.setRemover(getInvokerUserName());
		update(entity);
	}
	
    private Class<T> figureOutPersistentClass() {
        @SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>)((ParameterizedType) (getClass().getGenericSuperclass())).getActualTypeArguments()[0];
        return clazz;
    }
    
    private String getInvokerUserName() {	    
   	 return SecurityContextHolder.getContext().getAuthentication().getName();
   }
}
