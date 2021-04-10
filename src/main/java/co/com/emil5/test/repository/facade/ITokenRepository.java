package co.com.emil5.test.repository.facade;

import javax.ejb.Local;

import co.com.emil5.test.entity.Token;

@Local
public interface ITokenRepository extends IFacadeRepository<Token> {

	public Token getByClient(String email);

}
