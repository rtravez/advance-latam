package ec.advance.latam.com.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import ec.advance.latam.com.entity.Marca;
import ec.advance.latam.com.entity.Tipo;
import ec.advance.latam.com.exception.ExceptionManager;

public interface IMarcaService extends Serializable {

	public List<Marca> findMarcaByTipo(Tipo tipo) throws ExceptionManager;

	public Optional<Marca> findById(Long id) throws ExceptionManager;

}
