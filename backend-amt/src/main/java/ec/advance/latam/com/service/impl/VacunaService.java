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
 ARCHIVO:     VacunaService.java 
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
import org.springframework.transaction.annotation.Transactional;

import ec.advance.latam.com.dao.IVacunaDao;
import ec.advance.latam.com.entity.Vacuna;
import ec.advance.latam.com.exception.ExceptionManager;
import ec.advance.latam.com.service.IVacunaService;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * 
 * @author renetravez
 * @version $1.0$
 */
@Scope("singleton")
@Service("VacunaService")
public class VacunaService implements IVacunaService {
	private static final Logger LOG = LoggerFactory.getLogger(VacunaService.class);

	private static final long serialVersionUID = 1L;
	@Autowired
	private IVacunaDao vacunaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Vacuna> findAll() throws ExceptionManager {
		try {
			return vacunaDao.findAll();
		} catch (Exception e) {
			LOG.error("findAll: ", e);
			throw new ExceptionManager().new FindingException("Error al buscar el registro");
		}
	}
}
