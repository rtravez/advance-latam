package ec.advance.latam.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the restricciones database table.
 * 
 */
@Entity
@Table(name = "restricciones")
public class Restriccion {

	@Id
	@Column(name = "restriccion_id", unique = true, nullable = false, length = 20)
	private String restriccionId;

}
