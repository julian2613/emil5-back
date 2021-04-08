package co.com.emil5.test.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ManagerReporitory {

	@PersistenceContext(unitName = "test")
	protected EntityManager entityManager;

	
}
