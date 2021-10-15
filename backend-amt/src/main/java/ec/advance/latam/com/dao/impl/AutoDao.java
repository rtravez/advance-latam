package ec.advance.latam.com.dao.impl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

	@SuppressWarnings("unchecked")
	@Override
	public Optional<Auto> findAutoByPlaca(String placa) throws ExceptionManager {
		try {
			Query query = em.createQuery(
					"select a from Auto a join fetch a.modelo m join fetch m.marca ma join fetch ma.tipo t where a.placa =:placa");
			query.setParameter("placa", placa);
			return (Optional<Auto>) query.getSingleResult();
		} catch (Exception e) {
			LOG.error("findMarcaByTipo: ", e);
			throw new ExceptionManager().new FindingException("Error al buscar el registro");
		}
	}

}
