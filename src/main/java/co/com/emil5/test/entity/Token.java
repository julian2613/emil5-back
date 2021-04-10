package co.com.emil5.test.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
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

	public final static long VALIDITY = 60000;

	private static final long serialVersionUID = -7180136805985628852L;

	@Id
	@Column(name = "ID", length = 50, nullable = false)
	private String id;

	@Column(name = "CREATION_DATE", nullable = false)
	private Date creationDate;

	@OneToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "client_id", nullable = false, referencedColumnName = "id")
	private Client client;

	@PrePersist
	public void prePersist() {
		this.id = UUID.randomUUID().toString();
		this.creationDate = new Date();
		this.client.addVisit();
	}

	public String getValid() {
		if (this.id == null) {
			return "TOKEN IS MISSED";
		}
		if (new Date().getTime() - this.creationDate.getTime() > VALIDITY) {
			return "TOKEN NOT VALID";
		}

		return "TOKEN IS VALID";
	}

	public long getValidity() {
		if (this.creationDate != null) {
			return VALIDITY - (new Date().getTime() - this.creationDate.getTime());
		}
		return 0;
	}

}
