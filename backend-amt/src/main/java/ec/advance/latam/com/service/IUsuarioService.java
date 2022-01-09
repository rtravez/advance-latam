package ec.advance.latam.com.service;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import ec.advance.latam.com.entity.Usuario;
import ec.advance.latam.com.exception.ExceptionManager;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * 
 * @author renetravez
 * @version $1.0$
 */
public interface IUsuarioService extends IGenericService<Usuario, Long>,UserDetailsService, Serializable {

	public Optional<Usuario> findByUsername(String username) throws ExceptionManager;	
}
