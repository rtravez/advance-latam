package ec.advance.latam.com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the usuarios database table.
 */
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id", unique = true, nullable = false)
	private Long usuarioId;

	@Column(nullable = false, length = 60)
	private String password;

	@Column(nullable = false)
	private Boolean enabled;

	@Column(nullable = false, length = 20)
	private String username;

	// bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy = "usuario")
	private List<Empleado> empleados;

	// bi-directional many-to-one association to RolesUsuario
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<RolesUsuario> rolesUsuarios;

	public Usuario() {
	}

	public Usuario(String username, String password, Boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public Long getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setUsuario(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setUsuario(null);

		return empleado;
	}

	public List<RolesUsuario> getRolesUsuarios() {
		return this.rolesUsuarios;
	}

	public void setRolesUsuarios(List<RolesUsuario> rolesUsuarios) {
		this.rolesUsuarios = rolesUsuarios;
	}

	public RolesUsuario addRolesUsuario(RolesUsuario rolesUsuario) {
		getRolesUsuarios().add(rolesUsuario);
		rolesUsuario.setUsuario(this);

		return rolesUsuario;
	}

	public RolesUsuario removeRolesUsuario(RolesUsuario rolesUsuario) {
		getRolesUsuarios().remove(rolesUsuario);
		rolesUsuario.setUsuario(null);

		return rolesUsuario;
	}

}