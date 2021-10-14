package ec.advance.latam.com.dto;

import java.io.Serializable;
import java.util.Date;

public class MovilizacionDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long movilizacionId;

	private Boolean estado;

	private Date fecha;

	private AutoDto autoDto;

	private RestriccionDto restriccionDto;

	public MovilizacionDto() {
	}

	public RestriccionDto getRestriccionDto() {
		return restriccionDto;
	}

	public void setRestriccionDto(RestriccionDto restriccionDto) {
		this.restriccionDto = restriccionDto;
	}

	public Long getMovilizacionId() {
		return movilizacionId;
	}

	public void setMovilizacionId(Long movilizacionId) {
		this.movilizacionId = movilizacionId;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public AutoDto getAutoDto() {
		return autoDto;
	}

	public void setAutoDto(AutoDto autoDto) {
		this.autoDto = autoDto;
	}

}