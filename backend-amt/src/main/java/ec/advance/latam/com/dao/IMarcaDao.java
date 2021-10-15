package ec.advance.latam.com.dao;

import java.io.Serializable;
import java.util.List;

import ec.advance.latam.com.entity.Marca;
import ec.advance.latam.com.entity.Tipo;
import ec.advance.latam.com.exception.ExceptionManager;

public interface IMarcaDao extends IGenericDao<Marca, Long>, Serializable {

	public List<Marca> findMarcaByTipo(Tipo tipo) throws ExceptionManager;

}
