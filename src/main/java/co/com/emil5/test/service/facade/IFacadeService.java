package co.com.emil5.test.service.facade;

import co.com.emil5.test.excepcion.DatosExcepcion;

public interface IFacadeService<T> {

	public T save(T entity) throws DatosExcepcion;

}
