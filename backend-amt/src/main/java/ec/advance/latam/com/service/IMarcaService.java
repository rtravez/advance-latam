package ec.advance.latam.com.service;

import java.io.Serializable;
import java.util.List;

import ec.advance.latam.com.entity.Marca;
import ec.advance.latam.com.exception.ExceptionManager;

public interface IMarcaService extends Serializable {
	
	public List<Marca> findAll() throws ExceptionManager;

}
