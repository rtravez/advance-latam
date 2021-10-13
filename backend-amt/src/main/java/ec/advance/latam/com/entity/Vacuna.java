package ec.advance.latam.com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the vacunas database table.
 */
@Entity
@Table(name = "vacunas")
public class Vacuna implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	// @SequenceGenerator(name = "VACUNAS_VACUNAID_GENERATOR", sequenceName = "VACUNA_ID")
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VACUNAS_VACUNAID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vacuna_id", unique = true, nullable = false)
	private Long vacunaId;

	private Boolean estado;

	@Column(nullable = false, length = 20)
	private String nombre;

	// bi-directional many-to-one association to EmpleadosVacuna
	@OneToMany(mappedBy = "vacuna")
	private List<EmpleadosVacuna> empleadosVacunas;

	public Vacuna() {
		super();
	}

	public Long getVacunaId() {
		return this.vacunaId;
	}

	public void setVacunaId(Long vacunaId) {
		this.vacunaId = vacunaId;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<EmpleadosVacuna> getEmpleadosVacunas() {
		return this.empleadosVacunas;
	}

	public void setEmpleadosVacunas(List<EmpleadosVacuna> empleadosVacunas) {
		this.empleadosVacunas = empleadosVacunas;
	}

	public EmpleadosVacuna addEmpleadosVacuna(EmpleadosVacuna empleadosVacuna) {
		getEmpleadosVacunas().add(empleadosVacuna);
		empleadosVacuna.setVacuna(this);

		return empleadosVacuna;
	}

	public EmpleadosVacuna removeEmpleadosVacuna(EmpleadosVacuna empleadosVacuna) {
		getEmpleadosVacunas().remove(empleadosVacuna);
		empleadosVacuna.setVacuna(null);

		return empleadosVacuna;
	}

}