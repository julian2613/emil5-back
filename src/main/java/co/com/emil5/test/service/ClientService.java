package co.com.emil5.test.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.com.emil5.test.entity.Client;
import co.com.emil5.test.repository.ClientRepository;

@Stateless
public class ClientService {

	@EJB
	private ClientRepository clientRepository;

	public void save() {
		clientRepository.saveStudent(new Client("1", "nombre", "correo"));
	}

}
