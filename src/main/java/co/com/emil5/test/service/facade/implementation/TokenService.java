package co.com.emil5.test.service.facade.implementation;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.com.emil5.test.dto.TokenDto;
import co.com.emil5.test.entity.Client;
import co.com.emil5.test.entity.Token;
import co.com.emil5.test.repository.facade.IClientRepository;
import co.com.emil5.test.repository.facade.IFacadeRepository;
import co.com.emil5.test.repository.facade.ITokenRepository;
import co.com.emil5.test.service.facade.ITokenService;

@Stateless
public class TokenService extends FacadeService<Token> implements ITokenService {

	@EJB
	private ITokenRepository tokenRepository;

	@EJB
	private IClientRepository clientRepository;

	@Override
	protected IFacadeRepository<Token> getRepository() {
		return this.tokenRepository;
	}

	@Override
	public TokenDto generate(String clientId) {
		Token oldToken = this.tokenRepository.getByClient(clientId);

		if (oldToken == null) {
			return new TokenDto(this.newToken(clientId));
		} else {
			if (oldToken.getValid().equals("TOKEN IS VALID")) {
				oldToken.getClient().addVisit();
				this.clientRepository.save(oldToken.getClient());
				return new TokenDto(oldToken);
			} else {
				this.tokenRepository.delete(oldToken);
				return new TokenDto(this.newToken(clientId));
			}
		}
	}

	@Override
	public TokenDto validate(String id) {
		Token token = this.tokenRepository.readById(id);
		if (token == null) {
			return new TokenDto(new Token());
		}
		return new TokenDto(this.tokenRepository.readById(id));
	}

	private Token newToken(String clientId) {
		Client client = new Client();
		client.setId(clientId);

		Token token = new Token();
		token.setClient(client);

		return this.tokenRepository.save(token);
	}

}
