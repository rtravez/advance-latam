package ec.advance.latam.com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the tipos database table.
 * 
 */
@Entity
@Table(name = "tipos")
public class Tipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tipo_id", unique = true, nullable = false)
	private Long tipoId;

	@Column(nullable = false)
	private Boolean estado;

	@Column(nullable = false, length = 255)
	private String nombre;

	// bi-directional many-to-one association to Auto
	@OneToMany(mappedBy = "tipo", fetch = FetchType.LAZY)
	private List<Auto> autos;

	public Tipo() {
	}

	public Long getTipoId() {
		return this.tipoId;
	}

	public void setTipoId(Long tipoId) {
		this.tipoId = tipoId;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Auto> getAutos() {
		return this.autos;
	}

	public void setAutos(List<Auto> autos) {
		this.autos = autos;
	}

	public Auto addAuto(Auto auto) {
		getAutos().add(auto);
		auto.setTipo(this);

		return auto;
	}

	public Auto removeAuto(Auto auto) {
		getAutos().remove(auto);
		auto.setTipo(null);

		return auto;
	}

}