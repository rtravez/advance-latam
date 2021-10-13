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
 ARCHIVO:     EmpleadosVacunaService.java 
 DESCRIPCION: Descripcion de la clase, interface o enumeracion.
 *************************************************************************
                             	MODIFICACIONES

 FECHA         		AUTOR          					COMENTARIOS
 Oct 10, 2021 	        renetravez					   	 Emisión Inicial
 ***************************************************************************/
package ec.advance.latam.com.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ec.advance.latam.com.dao.IEmpleadosVacunaDao;
import ec.advance.latam.com.entity.EmpleadosVacuna;
import ec.advance.latam.com.exception.ExceptionManager;
import ec.advance.latam.com.service.IEmpleadosVacunaService;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * 
 * @author renetravez
 * @version $1.0$
 */
@Scope("singleton")
@Service("EmpleadosVacunaService")
public class EmpleadosVacunaService implements IEmpleadosVacunaService {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(EmpleadosVacunaService.class);
	@Autowired
	private IEmpleadosVacunaDao empleadosVacunaDao;

	@Override
	@Transactional(readOnly = true)
	public List<EmpleadosVacuna> findEmpleadosVacunaByCedula(String cedula) throws ExceptionManager {
		try {
			return empleadosVacunaDao.findEmpleadosVacunaByCedula(cedula);
		} catch (Exception e) {
			LOG.error("findEmpleadosVacunaByEmpleado: ", e);
			throw new ExceptionManager().new FindingException("Error al buscar el registro");
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = ExceptionManager.class)
	public EmpleadosVacuna save(EmpleadosVacuna empleadosVacuna) throws ExceptionManager {
		try {
			return empleadosVacunaDao.save(empleadosVacuna);
		} catch (Exception e) {
			LOG.error("save: ", e);
			throw new ExceptionManager().new GettingException("Error al guardar el registro");
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = ExceptionManager.class)
	public EmpleadosVacuna update(EmpleadosVacuna empleadosVacuna) throws ExceptionManager {
		try {
			return empleadosVacunaDao.save(empleadosVacuna);
		} catch (Exception e) {
			LOG.error("update: ", e);
			throw new ExceptionManager().new GettingException("Error al actualizar el registro");
		}
	}

}
