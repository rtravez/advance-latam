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
 ARCHIVO:     UsuarioService.java 
 DESCRIPCION: Descripcion de la clase, interface o enumeracion.
 *************************************************************************
                             	MODIFICACIONES

 FECHA         		AUTOR          					COMENTARIOS
 Oct 9, 2021 	        renetravez					   	 Emisión Inicial
 ***************************************************************************/
package ec.advance.latam.com.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ec.advance.latam.com.dao.IUsuarioDao;
import ec.advance.latam.com.entity.Usuario;
import ec.advance.latam.com.exception.ExceptionManager;
import ec.advance.latam.com.service.IUsuarioService;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * 
 * @author renetravez
 * @version $1.0$
 */
@Scope("singleton")
@Service("UsuarioService")
public class UsuarioService implements IUsuarioService {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(UsuarioService.class);
	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findByUsername(username).orElse(null);

		if (usuario == null) {
			LOG.error("Error en el Login: no existe el usuario '" + username + "' en el sistema!");
			throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
		}

		List<GrantedAuthority> authorities = usuario.getRolesUsuarios().stream().map(role -> new SimpleGrantedAuthority(role.getRole().getNombre()))
				.peek(authority -> LOG.info("Role ".concat(authority.getAuthority()))).collect(Collectors.toList());

		if (authorities.isEmpty()) {
			LOG.error("Error en el Login: Usuario " + username + " no tiene roles asignados!");
			throw new UsernameNotFoundException("Error en el Login: usuario " + username + " no tiene roles asignados!");
		}
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findByUsername(String username) {
		return usuarioDao.findByUsername(username);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = ExceptionManager.class)
	public Usuario save(Usuario usuario) throws ExceptionManager {
		try {
			return usuarioDao.save(usuario);
		} catch (Exception e) {
			LOG.error("save: ", e);
			throw new ExceptionManager().new GettingException("Error al guardar el registro");
		}
	}
}
