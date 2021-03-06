package ec.advance.latam.com.dto;

import java.io.Serializable;
import java.util.List;

public class RoleDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long rolId;

	private Boolean estado;

	private String nombre;

	private List<RolesUsuarioDto> rolesUsuarioDtos;

	public RoleDto() {
	}

	public Long getRolId() {
		return rolId;
	}

	public void setRolId(Long rolId) {
		this.rolId = rolId;
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

	public List<RolesUsuarioDto> getRolesUsuarioDtos() {
		return rolesUsuarioDtos;
	}

	public void setRolesUsuarioDtos(List<RolesUsuarioDto> rolesUsuarioDtos) {
		this.rolesUsuarioDtos = rolesUsuarioDtos;
	}

}