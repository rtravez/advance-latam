package ec.advance.latam.com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the empleados_vacunas database table.
 */
@Entity
@Table(name = "empleados_vacunas")
public class EmpleadosVacuna implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	// @SequenceGenerator(name = "EMPLEADOS_VACUNAS_EMPLEADOVACUNAID_GENERATOR",
	// sequenceName = "EMPLEADO_VACUNA_ID")
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "EMPLEADOS_VACUNAS_EMPLEADOVACUNAID_GENERATOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empleado_vacuna_id", unique = true, nullable = false)
	private Long empleadoVacunaId;

	@Column(nullable = false)
	private Short dosis;

	@Column(nullable = false)
	private Boolean estado;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_vacunacion", nullable = false)
	private Date fechaVacunacion;

	// bi-directional many-to-one association to Empleado
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empleado_id", nullable = false)
	private Empleado empleado;

	// bi-directional many-to-one association to Vacuna
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vacuna_id", nullable = false)
	private Vacuna vacuna;

	public EmpleadosVacuna() {
		super();
	}

	public Long getEmpleadoVacunaId() {
		return this.empleadoVacunaId;
	}

	public void setEmpleadoVacunaId(Long empleadoVacunaId) {
		this.empleadoVacunaId = empleadoVacunaId;
	}

	public Short getDosis() {
		return this.dosis;
	}

	public void setDosis(Short dosis) {
		this.dosis = dosis;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getFechaVacunacion() {
		return this.fechaVacunacion;
	}

	public void setFechaVacunacion(Date fechaVacunacion) {
		this.fechaVacunacion = fechaVacunacion;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Vacuna getVacuna() {
		return this.vacuna;
	}

	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}

}