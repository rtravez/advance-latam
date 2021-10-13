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
 ARCHIVO:     RolesUsuarioService.java 
 DESCRIPCION: Descripcion de la clase, interface o enumeracion.
 *************************************************************************
                             	MODIFICACIONES

 FECHA         		AUTOR          					COMENTARIOS
 Oct 9, 2021 	        renetravez					   	 Emisión Inicial
 ***************************************************************************/
package ec.advance.latam.com.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ec.advance.latam.com.dao.IRolesUsuarioDao;
import ec.advance.latam.com.entity.RolesUsuario;
import ec.advance.latam.com.exception.ExceptionManager;
import ec.advance.latam.com.service.IRolesUsuarioService;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * 
 * @author renetravez
 * @version $1.0$
 */
@Scope("singleton")
@Service("RolesUsuarioService")
public class RolesUsuarioService implements IRolesUsuarioService {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(RolesUsuarioService.class);

	@Autowired
	private IRolesUsuarioDao rolesUsuarioDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = ExceptionManager.class)
	public void save(RolesUsuario rolesUsuario) throws ExceptionManager {
		try {
			rolesUsuarioDao.save(rolesUsuario);
		} catch (Exception e) {
			LOG.error("save: ", e);
			throw new ExceptionManager().new GettingException("Error al guardar el registro");
		}
	}
}
