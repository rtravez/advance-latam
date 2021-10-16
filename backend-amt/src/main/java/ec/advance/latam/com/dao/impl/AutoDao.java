package ec.advance.latam.com.dao.impl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import ec.advance.latam.com.dao.IAutoDao;
import ec.advance.latam.com.entity.Auto;
import ec.advance.latam.com.exception.ExceptionManager;

public class AutoDao extends GenericDao<Auto, Long> implements IAutoDao {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(AutoDao.class);

	public AutoDao(JpaEntityInformation<Auto, Long> ei, EntityManager em) {
		super(ei, em);
	}

	@Override
	public Optional<Auto> findAutoByPlaca(String placa) throws ExceptionManager {
		try {
			TypedQuery<Auto> query = em.createQuery(
					"select a from Auto a join fetch a.modelo m join fetch m.marca ma join fetch ma.tipo t where a.placa =:placa",
					Auto.class);
			query.setParameter("placa", placa);
			return Optional.ofNullable(query.getSingleResult());
		} catch (Exception e) {
			LOG.error("findAutoByPlaca: ", e);
			throw new ExceptionManager().new FindingException("Error al buscar el registro");
		}
	}

	@Override
	public Optional<Auto> findAutoByChasis(String chasis) throws ExceptionManager {
		try {
			TypedQuery<Auto> query = em.createQuery(
					"select a from Auto a join fetch a.modelo m join fetch m.marca ma join fetch ma.tipo t where a.chasis =:chasis",
					Auto.class);
			query.setParameter("chasis", chasis);
			return Optional.ofNullable(query.getSingleResult());
		} catch (Exception e) {
			LOG.error("findAutoByChasis: ", e);
			throw new ExceptionManager().new FindingException("Error al buscar el registro");
		}
	}

}
