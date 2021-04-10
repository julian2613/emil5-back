package co.com.emil5.test.repository.facade.implementation;

import java.util.List;

import javax.ejb.Stateless;

import co.com.emil5.test.entity.Client;
import co.com.emil5.test.repository.facade.IClientRepository;

@Stateless
public class ClientRepository extends FacadeRepository<Client> implements IClientRepository {

	@Override
	protected Class<Client> getType() {
		return Client.class;
	}

	@Override
	public Client getByEmail(String email) {
		List<Client> clients = this.entityManager
				.createQuery("SELECT c FROM Client c WHERE c.email = :email", Client.class).setParameter("email", email)
				.getResultList();

		if (!clients.isEmpty()) {
			return clients.get(0);
		}

		return new Client();
	}

}
