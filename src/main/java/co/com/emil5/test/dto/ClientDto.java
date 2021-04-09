package co.com.emil5.test.dto;

import java.io.Serializable;

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
public class ClientDto implements Serializable {

	private static final long serialVersionUID = 509595540325254386L;

	private String id;

	private String name;

	private String email;

}
