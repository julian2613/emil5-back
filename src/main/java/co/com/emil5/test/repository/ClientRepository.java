package co.com.emil5.test.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.emil5.test.entity.Client;

@Stateless 
public class ClientRepository {

	@PersistenceContext(unitName = "test")
	protected EntityManager entityManager;

	public void saveStudent(Client student) {
		try {
			entityManager.persist(student);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

}
