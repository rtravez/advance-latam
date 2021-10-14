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
 * The persistent class for the movilizaciones database table.
 * 
 */
@Entity
@Table(name = "movilizaciones")
public class Movilizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movilizacion_id", unique = true, nullable = false)
	private Integer movilizacionId;

	@Column(nullable = false)
	private Boolean estado;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fecha;

	@Column(nullable = false, length = 255)
	private String descripcion;

	// bi-directional many-to-one association to Auto
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "auto_id", nullable = false)
	private Auto auto;

	// bi-directional many-to-one association to Restriccion
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restriccion_id", nullable = false)
	private Restriccion restriccion;

	public Movilizacion() {
	}

	public Integer getMovilizacionId() {
		return this.movilizacionId;
	}

	public void setMovilizacionId(Integer movilizacionId) {
		this.movilizacionId = movilizacionId;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Auto getAuto() {
		return this.auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

}