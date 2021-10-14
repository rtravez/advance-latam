package ec.advance.latam.com.dto;

import java.io.Serializable;
import java.util.List;

public class MarcaDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer marcaId;

	private Boolean estado;

	private String nombre;

	private List<ModeloDto> modeloDtos;

	public MarcaDto() {
	}

	public Integer getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(Integer marcaId) {
		this.marcaId = marcaId;
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

	public List<ModeloDto> getModeloDtos() {
		return modeloDtos;
	}

	public void setModeloDtos(List<ModeloDto> modeloDtos) {
		this.modeloDtos = modeloDtos;
	}
}