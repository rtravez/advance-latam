package ec.advance.latam.com.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AutoDto extends BaseDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long autoId;

	@NotEmpty
	@NotBlank
	private String chasis;

	@NotEmpty
	private String color;

	@NotEmpty
	@NotBlank
	private String placa;

	private String observacion;

	@NotNull
	private ModeloDto modeloDto;

	@JsonProperty(access = Access.WRITE_ONLY)
	private List<MovilizacionDto> movilizacionDtos;

	public AutoDto() {
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Long getAutoId() {
		return autoId;
	}

	public void setAutoId(Long autoId) {
		this.autoId = autoId;
	}

	public String getChasis() {
		return chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public ModeloDto getModeloDto() {
		return modeloDto;
	}

	public void setModeloDto(ModeloDto modeloDto) {
		this.modeloDto = modeloDto;
	}

	public List<MovilizacionDto> getMovilizacionDtos() {
		return movilizacionDtos;
	}

	public void setMovilizacionDtos(List<MovilizacionDto> movilizacionDtos) {
		this.movilizacionDtos = movilizacionDtos;
	}

}