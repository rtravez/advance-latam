package ec.advance.latam.com.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipoDto extends BaseDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long tipoId;

	private Boolean estado;

	private String nombre;

	private List<MarcaDto> marcaDtos;

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

	public List<MarcaDto> getMarcaDtos() {
		return marcaDtos;
	}

	public void setMarcaDtos(List<MarcaDto> marcaDtos) {
		this.marcaDtos = marcaDtos;
	}
}