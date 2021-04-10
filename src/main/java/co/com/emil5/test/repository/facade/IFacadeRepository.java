package co.com.emil5.test.repository.facade;

import java.util.List;

import co.com.emil5.test.excepcion.DatosExcepcion;

public interface IFacadeRepository<T> {

	public T save(T entity) throws DatosExcepcion;

	public T readById(String id);

	public List<T> readAll();

	public void delete(T entity);

	public void deleteById(String id);

}
