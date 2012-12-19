package ee.itcollege.borderproject.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ee.itcollege.borderproject.common.CrudDaoJpa;
import ee.itcollege.borderproject.dao.OccupationDao;
import ee.itcollege.borderproject.model.Occupation;

@Repository
public class OccuaptionDaoJpa extends CrudDaoJpa<Occupation> implements OccupationDao {

	@Override
	public List<Occupation> getAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			TypedQuery<Occupation> query = entityManager.createNamedQuery("Occupation.findAll", Occupation.class);
			return query.getResultList();
		}
		finally {
			entityManager.close();
		}
	}

}
