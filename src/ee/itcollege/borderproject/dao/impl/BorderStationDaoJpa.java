package ee.itcollege.borderproject.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ee.itcollege.borderproject.dao.BorderStationDao;
import ee.itcollege.borderproject.model.BorderStation;

@Repository
public class BorderStationDaoJpa implements BorderStationDao {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Team11BorderDb");
	
	@Override
	public List<BorderStation> getBorderStations() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try{
			TypedQuery<BorderStation> query = entityManager.createNamedQuery("BorderStation.findAll", BorderStation.class);
			List<BorderStation> borderStations = query.getResultList();
			return borderStations;
		}
		finally{
			entityManager.close();
		}
	}

	@Override
	public void saveBorderStation(BorderStation borderStation) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(borderStation);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

	@Override
	public void saveBorderStations(List<BorderStation> borderStations) {
		for(BorderStation borderStation : borderStations){
			saveBorderStation(borderStation);
		}
	}

	@Override
	public BorderStation searchborderStation(Integer id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try{
			return entityManager.find(BorderStation.class, id);
		}
		finally{
			entityManager.close();
		}
	}

	@Override
	public void updateBorderStation(BorderStation borderStation) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try{
			entityManager.getTransaction().begin();
			entityManager.merge(borderStation);
			entityManager.getTransaction().commit();
		}
		finally{
			entityManager.close();
		}
		
	}

	@Override
	public void deleteBorderStation(Integer id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try{
			entityManager.getTransaction().begin();
			BorderStation borderStation = entityManager.find(BorderStation.class, id);
			
			if(borderStation != null){
				entityManager.remove(borderStation);
			}
			
			entityManager.getTransaction().commit();
		}
		finally{
			entityManager.close();
		}
	}

}
