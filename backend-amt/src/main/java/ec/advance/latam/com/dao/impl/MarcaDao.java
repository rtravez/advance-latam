package ec.advance.latam.com.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import ec.advance.latam.com.dao.IMarcaDao;
import ec.advance.latam.com.entity.Marca;
import ec.advance.latam.com.entity.Tipo;
import ec.advance.latam.com.exception.ExceptionManager;

public class MarcaDao extends GenericDao<Marca, Long> implements IMarcaDao {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(MarcaDao.class);

	public MarcaDao(JpaEntityInformation<Marca, Long> ei, EntityManager em) {
		super(ei, em);
	}

	@Override
	public List<Marca> findMarcaByTipo(Tipo tipo) throws ExceptionManager {
		try {
			TypedQuery<Marca> query = em.createQuery("select m from Marca m where m.tipo.tipoId =:tipo", Marca.class);
			query.setParameter("tipo", tipo.getTipoId());
			return query.getResultList();
		} catch (Exception e) {
			LOG.error("findMarcaByTipo: ", e);
			throw new ExceptionManager().new FindingException("Error al buscar los registros");
		}
	}

}
