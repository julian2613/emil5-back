package co.com.emil5.test.service.facade.implementation;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.com.emil5.test.entity.Client;
import co.com.emil5.test.repository.facade.IClientRepository;
import co.com.emil5.test.repository.facade.IFacadeRepository;
import co.com.emil5.test.service.facade.IClientService;

@Stateless
public class ClientService extends FacadeService<Client> implements IClientService {

	@EJB
	private IClientRepository clientRepository;

	@Override
	protected IFacadeRepository<Client> getRepository() {
		return this.clientRepository;
	}

}
