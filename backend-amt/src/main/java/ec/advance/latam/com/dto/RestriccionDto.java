package ec.advance.latam.com.dto;

import java.io.Serializable;
import java.util.Date;

public class RestriccionDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String restriccionId;

	private Date fechaCreacion;

	private Boolean modificable;

	private Long valorEntero;

	private Double valorDecimal;

	private String valorCadena;

	private String descripcion;

	private Boolean estado;

	public RestriccionDto() {
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
