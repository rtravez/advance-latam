package ec.advance.latam.com.dto;

import java.io.Serializable;
import java.util.List;

public class TipoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long tipoId;

	private Boolean estado;

	private String nombre;

	private List<AutoDto> autoDtos;

	public TipoDto() {
	}

	public Long getTipoId() {
		return tipoId;
	}

	public void setTipoId(Long tipoId) {
		this.tipoId = tipoId;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<AutoDto> getAutoDtos() {
		return autoDtos;
	}

	public void setAutoDtos(List<AutoDto> autoDtos) {
		this.autoDtos = autoDtos;
	}
}