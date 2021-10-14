package ec.advance.latam.com.service;

import java.io.Serializable;
import java.util.List;

import ec.advance.latam.com.entity.Auto;
import ec.advance.latam.com.exception.ExceptionManager;

public interface IAutoService extends Serializable {

	public List<Auto> findAll() throws ExceptionManager;

	
}
