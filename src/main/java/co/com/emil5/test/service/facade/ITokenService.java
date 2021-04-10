package co.com.emil5.test.service.facade;

import javax.ejb.Local;

import co.com.emil5.test.dto.TokenDto;
import co.com.emil5.test.entity.Token;
import co.com.emil5.test.excepcion.DatosExcepcion;

@Local
public interface ITokenService extends IFacadeService<Token> {

	public TokenDto generate(String email) throws DatosExcepcion;

	public TokenDto validate(String id);

}
