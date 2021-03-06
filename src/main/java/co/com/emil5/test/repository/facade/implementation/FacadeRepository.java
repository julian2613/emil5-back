package co.com.emil5.test.repository.facade.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.emil5.test.excepcion.DatosExcepcion;

public abstract class FacadeRepository<T> {

	@PersistenceContext(unitName = "test")
	protected EntityManager entityManager;

	protected abstract Class<T> getType();

	public T save(T entity) throws DatosExcepcion {
		try {
			T newEntity = this.entityManager.merge(entity);
			this.entityManager.flush();

			return newEntity;
		} catch (Exception e) {
			throw new DatosExcepcion(e);
		}
	}

	public T readById(String id) {
		return this.entityManager.find(this.getType(), id);
	}

	public List<T> readAll() {
		return null;
	}

	public void delete(T entity) {
		this.entityManager.remove(entity);
		this.entityManager.flush();
	}

	public void deleteById(String id) {
		T entity = this.entityManager.find(getType(), id);
		this.entityManager.remove(entity);
	}

}
