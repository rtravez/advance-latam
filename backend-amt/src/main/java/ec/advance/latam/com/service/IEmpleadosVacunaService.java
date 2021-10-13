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
 ARCHIVO:     IEmpleadosVacunaService.java 
 DESCRIPCION: Descripcion de la clase, interface o enumeracion.
 *************************************************************************
                             	MODIFICACIONES

 FECHA         		AUTOR          					COMENTARIOS
 Oct 10, 2021 	        renetravez					   	 Emisión Inicial
 ***************************************************************************/
package ec.advance.latam.com.service;

import java.io.Serializable;
import java.util.List;

import ec.advance.latam.com.entity.EmpleadosVacuna;
import ec.advance.latam.com.exception.ExceptionManager;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * 
 * @author renetravez
 * @version $1.0$
 */
public interface IEmpleadosVacunaService extends Serializable {

	public List<EmpleadosVacuna> findEmpleadosVacunaByCedula(String cedula) throws ExceptionManager;

	public EmpleadosVacuna save(EmpleadosVacuna empleadosVacuna) throws ExceptionManager;

	public EmpleadosVacuna update(EmpleadosVacuna empleadosVacuna) throws ExceptionManager;
}
