package ec.advance.latam.com.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ModeloDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long modeloId;

	private Boolean estado;

	private String nombre;

	@NotNull
	private MarcaDto marcaDto;

	public ModeloDto() {
	}

	public Long getModeloId() {
		return modeloId;
	}

	public void setModeloId(Long modeloId) {
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