package ec.advance.latam.com.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import ec.advance.latam.com.entity.Tipo;
import ec.advance.latam.com.exception.ExceptionManager;

public interface ITipoService extends Serializable {

	public Optional<Tipo> findById(Long id) throws ExceptionManager;

	public List<Tipo> findAll() throws ExceptionManager;
}
