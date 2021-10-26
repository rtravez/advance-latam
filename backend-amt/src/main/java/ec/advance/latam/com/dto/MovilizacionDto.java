package ec.advance.latam.com.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

public class MovilizacionDto extends BaseDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long movilizacionId;

	private Boolean estado;

	@Future
	private Date fecha;

	private String descripcion;

	@NotNull
	private AutoDto autoDto;

	@NotNull
	private RestriccionDto restriccionDto;

	public MovilizacionDto() {
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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