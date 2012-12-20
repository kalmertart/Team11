package ee.itcollege.borderproject.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ee.itcollege.borderproject.common.CrudDaoJpa;
import ee.itcollege.borderproject.dao.GuardInBorderStationDao;
import ee.itcollege.borderproject.model.GuardInBorderStation;

@Repository
public class GuardInBorderStationDaoJpa extends CrudDaoJpa<GuardInBorderStation> implements GuardInBorderStationDao{

	@Override
	public List<GuardInBorderStation> getAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			TypedQuery<GuardInBorderStation> query = entityManager.createNamedQuery("GuardInBorderStation.findAll", GuardInBorderStation.class);
			return query.getResultList();
		}
		finally {
			entityManager.close();
		}
	}

	@Override
	public List<GuardInBorderStation> getWithDeleted() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			TypedQuery<GuardInBorderStation> query = entityManager.createNamedQuery("GuardInBorderStation.findWithDeleted", GuardInBorderStation.class);
			return query.getResultList();
		}
		finally {
			entityManager.close();
		}
	}

}
