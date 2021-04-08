package co.com.emil5.test.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "TOKEN")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Token implements Serializable {

	private static final long serialVersionUID = -7180136805985628852L;

	@Id
	@Column(name = "FECHA_CREACION", nullable = false)
	private Timestamp fechaCreacion;

}
