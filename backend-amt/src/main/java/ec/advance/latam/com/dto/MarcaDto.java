package ec.advance.latam.com.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

public class MarcaDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long marcaId;

	private Boolean estado;

	private String nombre;

	@NotNull
	private TipoDto tipoDto;

	private List<ModeloDto> modeloDtos;

	public MarcaDto() {
	}

	public TipoDto getTipoDto() {
		return tipoDto;
	}

	public void setTipoDto(TipoDto tipoDto) {
		this.tipoDto = tipoDto;
	}

	public Long getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(Long marcaId) {
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