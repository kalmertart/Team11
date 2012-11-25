package ee.itcollege.borderproject.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ee.itcollege.borderproject.dao.IncidentDao;
import ee.itcollege.borderproject.model.Incident;

@Repository
public class IncidentDaoJpa implements IncidentDao {
	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Team11BorderDb");
	
	@Override
	public List<Incident> getIncidents() {
		EntityManager enitytManager = entityManagerFactory.createEntityManager();
		try {
			TypedQuery<Incident> query = enitytManager.createNamedQuery("Incident.findAll", Incident.class);
			List<Incident> incidents = query.getResultList();
			return incidents;
		} 
		finally {
			enitytManager.close();
		}
	}

	@Override
	public void saveIncident(Incident incident) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(incident);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public void saveIncidents(List<Incident> incidents) {
		for (Incident incident : incidents) {
			saveIncident(incident);
		}
	}

	@Override
	public Incident searchIncident(Integer id) {
		EntityManager enitytManager = entityManagerFactory.createEntityManager();
		try {
			return enitytManager.find(Incident.class, id);
		} 
		finally {
			enitytManager.close();
		}
	}

	@Override
	public void updateIncident(Incident incident) {
		EntityManager enitytManager = entityManagerFactory.createEntityManager();
		try {
			enitytManager.getTransaction().begin();
			enitytManager.merge(incident);
			enitytManager.getTransaction().commit();
		} 
		finally {
			enitytManager.close();
		}
	}

	@Override
	public void deleteIncident(Integer id) {
		EntityManager enitytManager = entityManagerFactory.createEntityManager();
		
		try {
			enitytManager.getTransaction().begin();			
			Incident incident = enitytManager.find(Incident.class, id);
			
			if (incident != null) {
				enitytManager.remove(incident);
			}
			
			enitytManager.getTransaction().commit();
		} 
		finally {
			enitytManager.close();
		}
	}
	
}
