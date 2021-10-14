package ec.advance.latam.com.dto;

import java.io.Serializable;
import java.util.List;

public class AutoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long autoId;

	private String chasis;

	private String color;

	private String placa;

	private ModeloDto modeloDto;

	private TipoDto tipoDto;

	private List<MovilizacionDto> movilizacionDtos;

	public AutoDto() {
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

	public TipoDto getTipoDto() {
		return tipoDto;
	}

	public void setTipoDto(TipoDto tipoDto) {
		this.tipoDto = tipoDto;
	}

	public List<MovilizacionDto> getMovilizacionDtos() {
		return movilizacionDtos;
	}

	public void setMovilizacionDtos(List<MovilizacionDto> movilizacionDtos) {
		this.movilizacionDtos = movilizacionDtos;
	}

}