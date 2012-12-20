package ee.itcollege.borderproject.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ee.itcollege.borderproject.common.CrudDaoJpa;
import ee.itcollege.borderproject.dao.GuardDao;
import ee.itcollege.borderproject.model.Guard;

@Repository
public class GuardDaoJpa extends CrudDaoJpa<Guard> implements GuardDao {
	
	@Override
	public List<Guard> getAll() {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			TypedQuery<Guard> q = em.createNamedQuery("Guard.findAll",Guard.class);
			return q.getResultList();
		} 
		finally {
			em.close();
		}
	}

	@Override
	public List<Guard> getWithDeleted() {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			TypedQuery<Guard> q = em.createNamedQuery("Guard.findWithDeleted",Guard.class);
			return q.getResultList();
		} 
		finally {
			em.close();
		}
	}

}
