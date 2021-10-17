package ec.advance.latam.com.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import ec.advance.latam.com.dao.IModeloDao;
import ec.advance.latam.com.entity.Marca;
import ec.advance.latam.com.entity.Modelo;
import ec.advance.latam.com.exception.ExceptionManager;

public class ModeloDao extends GenericDao<Modelo, Long> implements IModeloDao {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(ModeloDao.class);

	public ModeloDao(JpaEntityInformation<Modelo, Long> ei, EntityManager em) {
		super(ei, em);
	}

	@Override
	public List<Modelo> findModeloByMarca(Marca marca) throws ExceptionManager {
		try {
			TypedQuery<Modelo> query = em.createQuery("select m from Modelo m where m.marca.marcaId =:marca", Modelo.class);
			query.setParameter("marca", marca.getMarcaId());
			return query.getResultList();
		} catch (Exception e) {
			LOG.error("findModeloByMarca: ", e);
			throw new ExceptionManager().new FindingException("Error al buscar los registros");
		}
	}

}
