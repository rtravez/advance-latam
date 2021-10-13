package ec.advance.latam.com.dto;

import java.io.Serializable;
import java.util.Date;

public class EmpleadosVacunaDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long empleadoVacunaId;

	private Short dosis;

	private Boolean estado;

	private Date fechaVacunacion;

	private EmpleadoDto empleadoDto;

	private VacunaDto vacunaDto;

	public EmpleadosVacunaDto() {
	}

	public Long getEmpleadoVacunaId() {
		return empleadoVacunaId;
	}

	public void setEmpleadoVacunaId(Long empleadoVacunaId) {
		this.empleadoVacunaId = empleadoVacunaId;
	}

	public Short getDosis() {
		return dosis;
	}

	public void setDosis(Short dosis) {
		this.dosis = dosis;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getFechaVacunacion() {
		return fechaVacunacion;
	}

	public void setFechaVacunacion(Date fechaVacunacion) {
		this.fechaVacunacion = fechaVacunacion;
	}

	public EmpleadoDto getEmpleadoDto() {
		return empleadoDto;
	}

	public void setEmpleadoDto(EmpleadoDto empleadoDto) {
		this.empleadoDto = empleadoDto;
	}

	public VacunaDto getVacunaDto() {
		return vacunaDto;
	}

	public void setVacunaDto(VacunaDto vacunaDto) {
		this.vacunaDto = vacunaDto;
	}

}