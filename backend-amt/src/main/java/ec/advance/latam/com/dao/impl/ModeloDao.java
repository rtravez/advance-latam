package ec.advance.latam.com.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import ec.advance.latam.com.dao.IModeloDao;
import ec.advance.latam.com.entity.Marca;
import ec.advance.latam.com.entity.Modelo;
import ec.advance.latam.com.exception.ExceptionManager;

public class ModeloDao extends GenericDao<Modelo, Long> implements IModeloDao {

	private static final long serialVersionUID = 1L;

	public ModeloDao(JpaEntityInformation<Modelo, Long> ei, EntityManager em) {
		super(ei, em);
	}

	@Override
	public List<Modelo> findModeloByMarca(Marca marca) throws ExceptionManager {
		return null;
	}

}
