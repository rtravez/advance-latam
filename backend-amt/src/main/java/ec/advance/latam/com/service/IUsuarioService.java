/**************************************************************************
				(c) Copyright ADVANCE-LATAM 2021
                             www.advance.latam.com
                             info@advance.latam.com

 Este programa de computador es propiedad de ADVANCE-LATAM y esta 
 protegido por las leyes y tratados internacionales de derechos de 
 autor. El uso, reproducción o distribución no autorizada de este programa, 
 o cualquier porción de él, puede dar lugar a sanciones criminales y 
 civiles severas, y serán procesadas con el grado máximo contemplado 
 por la ley.
 
 ************************************************************************* 
 PROYECTO:	  backend-amt  
 ARCHIVO:     IUsuarioService.java 
 DESCRIPCION: Descripcion de la clase, interface o enumeracion.
 *************************************************************************
                             	MODIFICACIONES

 FECHA         		AUTOR          					COMENTARIOS
 Oct 9, 2021 	        renetravez					   	 Emisión Inicial
 ***************************************************************************/
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
public interface IUsuarioService extends Serializable, UserDetailsService {

	public Optional<Usuario> findByUsername(String username);

	public Usuario save(Usuario usuario) throws ExceptionManager;
}
