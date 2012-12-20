package ee.itcollege.borderproject.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ee.itcollege.borderproject.common.CrudDaoJpa;
import ee.itcollege.borderproject.dao.OccupationInBorderStationDao;
import ee.itcollege.borderproject.model.OccupationInBorderStation;

@Repository
public class OccupationInBorderStationDaoJpa extends CrudDaoJpa<OccupationInBorderStation> implements OccupationInBorderStationDao {

	@Override
	public List<OccupationInBorderStation> getAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			TypedQuery<OccupationInBorderStation> query = 
					entityManager.createNamedQuery("OccupationInBorderStation.findAll", OccupationInBorderStation.class);
			
			return query.getResultList();
		}
		finally {
			entityManager.close();
		}
	}

	@Override
	public List<OccupationInBorderStation> getWithDeleted() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			TypedQuery<OccupationInBorderStation> query = 
					entityManager.createNamedQuery("OccupationInBorderStation.findWithDeleted",OccupationInBorderStation.class);
			
			return query.getResultList();
		} finally {
			entityManager.close();
		}
	}

}
