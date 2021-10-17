package ec.advance.latam.com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the restricciones database table.
 */
@Entity
@Table(name = "restricciones")
public class Restriccion {

	@Id
	@Column(name = "restriccion_id", unique = true, nullable = false, length = 20)
	private String restriccionId;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion;

	@Column(nullable = false)
	private Boolean modificable;

	@Column(name = "valor_entero", nullable = true)
	private Long valorEntero;

	@Column(name = "valor_decimal", nullable = true)
	private Double valorDecimal;

	@Column(name = "valor_cadena", nullable = true)
	private String valorCadena;

	@Column(nullable = false, length = 255)
	private String descripcion;

	@Column(nullable = false)
	private Boolean estado;

	public Restriccion() {
	}

	public String getRestriccionId() {
		return restriccionId;
	}

	public void setRestriccionId(String restriccionId) {
		this.restriccionId = restriccionId;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Boolean getModificable() {
		return modificable;
	}

	public void setModificable(Boolean modificable) {
		this.modificable = modificable;
	}

	public Long getValorEntero() {
		return valorEntero;
	}

	public void setValorEntero(Long valorEntero) {
		this.valorEntero = valorEntero;
	}

	public Double getValorDecimal() {
		return valorDecimal;
	}

	public void setValorDecimal(Double valorDecimal) {
		this.valorDecimal = valorDecimal;
	}

	public String getValorCadena() {
		return valorCadena;
	}

	public void setValorCadena(String valorCadena) {
		this.valorCadena = valorCadena;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
