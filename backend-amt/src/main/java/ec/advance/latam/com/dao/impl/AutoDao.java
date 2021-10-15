package ec.advance.latam.com.dao.impl;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import ec.advance.latam.com.dao.IAutoDao;
import ec.advance.latam.com.entity.Auto;
import ec.advance.latam.com.exception.ExceptionManager;

public class AutoDao extends GenericDao<Auto, Long> implements IAutoDao {

	private static final long serialVersionUID = 1L;

	public AutoDao(JpaEntityInformation<Auto, Long> ei, EntityManager em) {
		super(ei, em);
	}

	@Override
	public Optional<Auto> findAutoByPlaca(String placa) throws ExceptionManager {
		return null;
	}

}
