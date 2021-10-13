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
 ARCHIVO:     EmpleadosVacunaController.java 
 DESCRIPCION: Descripcion de la clase, interface o enumeracion.
 *************************************************************************
                             	MODIFICACIONES

 FECHA         		AUTOR          					COMENTARIOS
 Oct 10, 2021 	        renetravez					   	 Emisión Inicial
 ***************************************************************************/
package ec.advance.latam.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.advance.latam.com.entity.EmpleadosVacuna;
import ec.advance.latam.com.mapper.IEmpleadosVacunaMapper;
import ec.advance.latam.com.service.IEmpleadosVacunaService;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * 
 * @author renetravez
 * @version $1.0$
 */
@RestController()
@RequestMapping("/api")
public class EmpleadosVacunaController {

	private static final Logger LOG = LoggerFactory.getLogger(EmpleadosVacunaController.class);
	@Autowired
	private IEmpleadosVacunaService empleadosVacunaService;
	@Autowired
	private IEmpleadosVacunaMapper empleadosVacunaMapper;
	private Map<String, Object> response;

	public EmpleadosVacunaController() {
		response = new HashMap<>();
	}

	@Secured({ "ROLE_USER" })
	@GetMapping("/empleadosvacuna/{cedula}")
	public ResponseEntity<?> findEmpleadosVacunaByCedula(@PathVariable String cedula) {
		response = new HashMap<>();
		try {
			List<EmpleadosVacuna> empleadosVacunas = empleadosVacunaService.findEmpleadosVacunaByCedula(cedula);

			if (empleadosVacunas.isEmpty()) {
				response.put("mensaje", "El empleado no registra vacunas");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
			return ResponseEntity.ok().body(empleadosVacunaMapper.listEmpleadosVacunaToListEmpleadosVacunaDto(empleadosVacunas));
		} catch (Exception e) {
			LOG.error("findEmpleadosVacunaByCedula: ", e);
			response.put("mensaje", "Error al realizar la consulta");
			response.put("error", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
