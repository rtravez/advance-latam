package ec.advance.latam.com.service;

import java.io.Serializable;
import java.util.List;

import ec.advance.latam.com.entity.Tipo;
import ec.advance.latam.com.exception.ExceptionManager;

public interface ITipoService extends Serializable {

	public List<Tipo> findAll() throws ExceptionManager;
}
