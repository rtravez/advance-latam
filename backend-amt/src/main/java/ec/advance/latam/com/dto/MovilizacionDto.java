package ec.advance.latam.com.dto;

import java.io.Serializable;
import java.util.Date;

public class MovilizacionDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer movilizacionId;

	private Boolean estado;

	private Date fecha;

	private AutoDto autoDto;

	public MovilizacionDto() {
	}

	public Integer getMovilizacionId() {
		return movilizacionId;
	}

	public void setMovilizacionId(Integer movilizacionId) {
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