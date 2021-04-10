package co.com.emil5.test.repository.facade.implementation;

import java.util.List;

import javax.ejb.Stateless;

import co.com.emil5.test.entity.Token;
import co.com.emil5.test.repository.facade.ITokenRepository;

@Stateless
public class TokenRepository extends FacadeRepository<Token> implements ITokenRepository {

	@Override
	protected Class<Token> getType() {
		return Token.class;
	}

	@Override
	public Token getByClient(String email) {
		List<Token> tokens = this.entityManager
				.createQuery("SELECT t FROM Token t WHERE t.client.email = :email", Token.class)
				.setParameter("clientId", email).getResultList();

		if (!tokens.isEmpty()) {
			return tokens.get(0);
		}

		return new Token();
	}

}
