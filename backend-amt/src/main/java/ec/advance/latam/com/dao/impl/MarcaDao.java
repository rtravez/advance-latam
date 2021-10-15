package ec.advance.latam.com.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import ec.advance.latam.com.dao.IMarcaDao;
import ec.advance.latam.com.entity.Marca;
import ec.advance.latam.com.entity.Tipo;
import ec.advance.latam.com.exception.ExceptionManager;

public class MarcaDao extends GenericDao<Marca, Long> implements IMarcaDao {

	private static final long serialVersionUID = 1L;

	public MarcaDao(JpaEntityInformation<Marca, Long> ei, EntityManager em) {
		super(ei, em);
	}

	@Override
	public List<Marca> findMarcaByTipo(Tipo tipo) throws ExceptionManager {
		return null;
	}

}
