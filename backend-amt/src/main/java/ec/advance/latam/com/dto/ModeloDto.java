package ec.advance.latam.com.dto;

import java.io.Serializable;

public class ModeloDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer modeloId;

	private Boolean estado;

	private String nombre;

	private MarcaDto marcaDto;

	public ModeloDto() {
	}

	public Integer getModeloId() {
		return modeloId;
	}

	public void setModeloId(Integer modeloId) {
		this.modeloId = modeloId;
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

	public MarcaDto getMarcaDto() {
		return marcaDto;
	}

	public void setMarcaDto(MarcaDto marcaDto) {
		this.marcaDto = marcaDto;
	}

}