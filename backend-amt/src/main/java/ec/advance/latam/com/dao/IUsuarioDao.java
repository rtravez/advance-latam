package ec.advance.latam.com.dao;

import java.io.Serializable;
import java.util.Optional;

import ec.advance.latam.com.entity.Usuario;
import ec.advance.latam.com.exception.ExceptionManager;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * 
 * @author renetravez
 * @version $1.0$
 */
public interface IUsuarioDao extends IGenericDao<Usuario, Long>, Serializable {

	//@Query("select u from Usuario u where u.username = ?1")
	public Optional<Usuario> findByUsername(String username) throws ExceptionManager;

}
