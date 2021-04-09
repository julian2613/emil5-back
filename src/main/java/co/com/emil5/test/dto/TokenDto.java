package co.com.emil5.test.dto;

import java.io.Serializable;

import co.com.emil5.test.entity.Token;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TokenDto implements Serializable {

	private static final long serialVersionUID = -2728214651909818903L;

	private String token;

	private String valid;

	private long validity;

	/*private ClientDto client = new ClientDto();*/

	public TokenDto(Token token) {
		/*this.getClient().setId(token.getClient().getId());
		this.getClient().setName(token.getClient().getName());
		this.getClient().setEmail(token.getClient().getEmail());*/

		this.setToken(token.getId());
		this.setValidity(token.getValidity());
		this.setValid(token.getValid());
	}

}
