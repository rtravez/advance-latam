package ec.advance.latam.com.dao.impl;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;

import ec.advance.latam.com.dao.IUsuarioDao;
import ec.advance.latam.com.entity.Usuario;
import ec.advance.latam.com.exception.ExceptionManager;

public class UsuarioDao extends GenericDao<Usuario, Long> implements IUsuarioDao {

	private static final long serialVersionUID = 1L;

	public UsuarioDao(JpaEntityInformation<Usuario, Long> ei, EntityManager em) {
		super(ei, em);
	}

	@Override
	public Optional<Usuario> findByUsername(String username) throws ExceptionManager {
		// TODO Auto-generated method stub
		return null;
	}

}
