package ec.advance.latam.com.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import ec.advance.latam.com.dao.IMarcaDao;
import ec.advance.latam.com.entity.Marca;

public class MarcaDao extends GenericDao<Marca, Long> implements IMarcaDao {

	private static final long serialVersionUID = 1L;

	/*public MarcaDao(Class<Marca> domainClass, EntityManager em) {
		super(domainClass, em);
	}*/

	/*public MarcaDao(EntityManager em) {
		super(Marca.class, em);*/

	

	public MarcaDao(JpaEntityInformation<Marca, Long> ei, EntityManager em) {
		super(ei, em);
	}

}
