package co.com.emil5.test.service.facade;

import javax.ejb.Local;

import co.com.emil5.test.entity.Client;

@Local
public interface IClientService extends IFacadeService<Client> {

}
