package ec.advance.latam.com.dao;

import java.io.Serializable;
import java.util.Optional;

import ec.advance.latam.com.entity.Restriccion;
import ec.advance.latam.com.exception.ExceptionManager;

public interface IRestriccionDao extends IGenericDao<Restriccion, String>, Serializable {

	public Optional<Restriccion> findRestriccionByValorEntero(Long valorEntero) throws ExceptionManager;

}
