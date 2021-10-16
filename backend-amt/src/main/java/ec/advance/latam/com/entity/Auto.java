package ec.advance.latam.com.entity;

import java.io.Serializable;
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

/**
 * The persistent class for the autos database table.
 * 
 */
@Entity
@Table(name = "autos")
public class Auto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auto_id", unique = true, nullable = false)
	private Long autoId;

	@Column(unique = true, nullable = false, length = 255)
	private String chasis;

	@Column(nullable = true, length = 300)
	private String observacion;

	@Column(nullable = false, length = 50)
	private String color;

	@Column(unique = true, nullable = false, length = 10)
	private String placa;

	// bi-directional many-to-one association to Modelo
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modelo_id", nullable = false)
	private Modelo modelo;

	// bi-directional many-to-one association to Movilizacion
	@OneToMany(mappedBy = "auto", fetch = FetchType.LAZY)
	private List<Movilizacion> movilizaciones;

	public Auto() {
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Long getAutoId() {
		return this.autoId;
	}

	public void setAutoId(Long autoId) {
		this.autoId = autoId;
	}

	public String getChasis() {
		return this.chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public List<Movilizacion> getMovilizaciones() {
		return this.movilizaciones;
	}

	public void setMovilizaciones(List<Movilizacion> movilizaciones) {
		this.movilizaciones = movilizaciones;
	}

	public Movilizacion addMovilizacione(Movilizacion movilizacione) {
		getMovilizaciones().add(movilizacione);
		movilizacione.setAuto(this);

		return movilizacione;
	}

	public Movilizacion removeMovilizacione(Movilizacion movilizacione) {
		getMovilizaciones().remove(movilizacione);
		movilizacione.setAuto(null);

		return movilizacione;
	}

}