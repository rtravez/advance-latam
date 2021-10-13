package ec.advance.latam.com.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class EmpleadoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long empleadoId;

	@NotEmpty
	private String apellidos;
	@NotEmpty
	@Size(min = 10, max = 10)
	private String cedula;

	private String celular;
	@NotEmpty
	private String correo;

	private String direccion;

	private Boolean estado = Boolean.TRUE;

	private Date fechaNacimiento;
	@NotEmpty
	private String nombres;

	private Boolean vacunado = Boolean.FALSE;

	private UsuarioDto usuarioDto;
	private List<EmpleadosVacunaDto> empleadosVacunaDtos;

	public EmpleadoDto() {
	}

	public List<EmpleadosVacunaDto> getEmpleadosVacunaDtos() {
		return empleadosVacunaDtos;
	}

	public void setEmpleadosVacunaDtos(List<EmpleadosVacunaDto> empleadosVacunaDtos) {
		this.empleadosVacunaDtos = empleadosVacunaDtos;
	}

	public Long getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(Long empleadoId) {
		this.empleadoId = empleadoId;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Boolean getVacunado() {
		return vacunado;
	}

	public void setVacunado(Boolean vacunado) {
		this.vacunado = vacunado;
	}

	public UsuarioDto getUsuarioDto() {
		return usuarioDto;
	}

	public void setUsuarioDto(UsuarioDto usuarioDto) {
		this.usuarioDto = usuarioDto;
	}

}