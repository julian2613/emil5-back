package co.com.emil5.test.repository.facade.implementation;

import javax.ejb.Stateless;

import co.com.emil5.test.entity.Client;
import co.com.emil5.test.repository.facade.IClientRepository;

@Stateless
public class ClientRepository extends FacadeRepository<Client> implements IClientRepository {

	@Override
	protected Class<Client> getType() {
		return Client.class;
	}

}
