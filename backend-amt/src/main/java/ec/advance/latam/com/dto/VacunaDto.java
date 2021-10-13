package ec.advance.latam.com.dto;

import java.io.Serializable;
import java.util.List;

public class VacunaDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long vacunaId;

	private Boolean estado;

	private String nombre;
	private List<EmpleadosVacunaDto> empleadosVacunaDtos;

	public VacunaDto() {
	}

	public Long getVacunaId() {
		return vacunaId;
	}

	public void setVacunaId(Long vacunaId) {
		this.vacunaId = vacunaId;
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

	public List<EmpleadosVacunaDto> getEmpleadosVacunaDtos() {
		return empleadosVacunaDtos;
	}

	public void setEmpleadosVacunaDtos(List<EmpleadosVacunaDto> empleadosVacunaDtos) {
		this.empleadosVacunaDtos = empleadosVacunaDtos;
	}

}