package ec.advance.latam.com.dao.impl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import ec.advance.latam.com.dao.IRestriccionDao;
import ec.advance.latam.com.entity.Restriccion;
import ec.advance.latam.com.exception.ExceptionManager;

public class RestriccionDao extends GenericDao<Restriccion, String> implements IRestriccionDao {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(RestriccionDao.class);

	public RestriccionDao(JpaEntityInformation<Restriccion, String> ei, EntityManager em) {
		super(ei, em);
	}

	@Override
	public Optional<Restriccion> findRestriccionByValorEntero(Long valorEntero) throws ExceptionManager {
		try {
			TypedQuery<Restriccion> query = em.createQuery("select r from Restriccion r where r.valorEntero =:valorEntero", Restriccion.class);
			query.setParameter("valorEntero", valorEntero);
			return Optional.ofNullable(query.getSingleResult());
		} catch (Exception e) {
			LOG.error("findRestriccionByValorEntero: ", e);
			throw new ExceptionManager().new FindingException("Error al buscar el registro");
		}
	}

}
