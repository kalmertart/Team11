package ee.itcollege.borderproject.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ee.itcollege.borderproject.common.CrudDaoJpa;
import ee.itcollege.borderproject.dao.BorderStationDao;
import ee.itcollege.borderproject.model.BorderStation;

@Repository
public class BorderStationDaoJpa extends CrudDaoJpa<BorderStation> implements BorderStationDao {

	@Override
	public List<BorderStation> getAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			TypedQuery<BorderStation> query = entityManager.createNamedQuery("BorderStation.findAll", BorderStation.class);
			return query.getResultList();
		} 
		finally {
			entityManager.close();
		}
	}

	@Override
	public List<BorderStation> getWithDeleted() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			TypedQuery<BorderStation> query = entityManager.createNamedQuery("BorderStation.findWithDeleted", BorderStation.class);
			return query.getResultList();
		} 
		finally {
			entityManager.close();
		}
	}

}
