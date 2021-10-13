package ec.advance.latam.com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the empleados database table.
 */
@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empleado_id", unique = true, nullable = false)
	private Long empleadoId;

	@Column(nullable = false, length = 255)
	private String apellidos;

	@Column(nullable = false, length = 10)
	private String cedula;

	@Column(nullable = true, length = 10)
	private String celular;

	@Column(nullable = false, length = 100)
	private String correo;

	@Column(nullable = true, length = 500)
	private String direccion;

	@Column(nullable = false)
	private Boolean estado;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento", nullable = true)
	private Date fechaNacimiento;

	@Column(nullable = false, length = 255)
	private String nombres;

	private Boolean vacunado;

	// bi-directional many-to-one association to Usuario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	// bi-directional many-to-one association to EmpleadosVacuna
	@OneToMany(mappedBy = "empleado")
	private List<EmpleadosVacuna> empleadosVacunas;

	public Empleado() {
		super();
	}

	public Long getEmpleadoId() {
		return this.empleadoId;
	}

	public void setEmpleadoId(Long empleadoId) {
		this.empleadoId = empleadoId;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Boolean getVacunado() {
		return this.vacunado;
	}

	public void setVacunado(Boolean vacunado) {
		this.vacunado = vacunado;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<EmpleadosVacuna> getEmpleadosVacunas() {
		return this.empleadosVacunas;
	}

	public void setEmpleadosVacunas(List<EmpleadosVacuna> empleadosVacunas) {
		this.empleadosVacunas = empleadosVacunas;
	}

	public EmpleadosVacuna addEmpleadosVacuna(EmpleadosVacuna empleadosVacuna) {
		getEmpleadosVacunas().add(empleadosVacuna);
		empleadosVacuna.setEmpleado(this);

		return empleadosVacuna;
	}

	public EmpleadosVacuna removeEmpleadosVacuna(EmpleadosVacuna empleadosVacuna) {
		getEmpleadosVacunas().remove(empleadosVacuna);
		empleadosVacuna.setEmpleado(null);

		return empleadosVacuna;
	}

}