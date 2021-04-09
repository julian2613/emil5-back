package co.com.emil5.test.repository.facade;

import javax.ejb.Local;

import co.com.emil5.test.entity.Client;

@Local
public interface IClientRepository extends IFacadeRepository<Client> {

}
