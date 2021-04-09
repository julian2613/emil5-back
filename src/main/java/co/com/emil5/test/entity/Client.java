package co.com.emil5.test.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CLIENT")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class Client implements Serializable {

	private static final long serialVersionUID = 1207229082275241955L;

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	private String id;

	@Column(name = "NAME", length = 255, nullable = false)
	private String name;

	@Column(name = "EMAIL", length = 255, unique = true, nullable = false)
	private String email;

	@Column(name = "VISITS", nullable = false)
	private long visits;

	@PrePersist
	public void prePersist() {
		this.id = UUID.randomUUID().toString();
	}

	public void addVisit() {
		this.visits++;
	}

}
