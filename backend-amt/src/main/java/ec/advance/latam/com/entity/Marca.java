package ec.advance.latam.com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the marcas database table.
 * 
 */
@Entity
@Table(name = "marcas")
public class Marca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "marca_id", unique = true, nullable = false)
	private Integer marcaId;

	@Column(nullable = false)
	private Boolean estado;

	@Column(nullable = false, length = 255)
	private String nombre;

	// bi-directional many-to-one association to Auto
	@OneToMany(mappedBy = "marca")
	private List<Auto> autos;

	// bi-directional many-to-one association to Modelo
	@OneToMany(mappedBy = "marca")
	private List<Modelo> modelos;

	public Marca() {
	}

	public Integer getMarcaId() {
		return this.marcaId;
	}

	public void setMarcaId(Integer marcaId) {
		this.marcaId = marcaId;
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
		auto.setMarca(this);

		return auto;
	}

	public Auto removeAuto(Auto auto) {
		getAutos().remove(auto);
		auto.setMarca(null);

		return auto;
	}

	public List<Modelo> getModelos() {
		return this.modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

	public Modelo addModelo(Modelo modelo) {
		getModelos().add(modelo);
		modelo.setMarca(this);

		return modelo;
	}

	public Modelo removeModelo(Modelo modelo) {
		getModelos().remove(modelo);
		modelo.setMarca(null);

		return modelo;
	}

}