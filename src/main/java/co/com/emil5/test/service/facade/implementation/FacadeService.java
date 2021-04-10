package co.com.emil5.test.service.facade.implementation;

import co.com.emil5.test.excepcion.DatosExcepcion;
import co.com.emil5.test.repository.facade.IFacadeRepository;

public abstract class FacadeService<T> {

	protected abstract IFacadeRepository<T> getRepository();

	public T save(T entity) throws DatosExcepcion {
		return this.getRepository().save(entity);
	}

}
