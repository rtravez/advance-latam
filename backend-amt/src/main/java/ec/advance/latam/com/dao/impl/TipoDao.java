package ec.advance.latam.com.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import ec.advance.latam.com.dao.ITipoDao;
import ec.advance.latam.com.entity.Tipo;

public class TipoDao extends GenericDao<Tipo, Long> implements ITipoDao {

	private static final long serialVersionUID = 1L;

	public TipoDao(JpaEntityInformation<Tipo, Long> ei, EntityManager em) {
		super(ei, em);
	}

}
