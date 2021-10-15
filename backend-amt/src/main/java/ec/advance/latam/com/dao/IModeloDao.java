package ec.advance.latam.com.dao;

import java.io.Serializable;
import java.util.List;

import ec.advance.latam.com.entity.Marca;
import ec.advance.latam.com.entity.Modelo;
import ec.advance.latam.com.exception.ExceptionManager;

public interface IModeloDao extends IGenericDao<Modelo, Long>, Serializable {

	public List<Modelo> findModeloByMarca(Marca marca) throws ExceptionManager;

}
