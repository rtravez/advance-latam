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
 ARCHIVO:     VacunaController.java 
 DESCRIPCION: Descripcion de la clase, interface o enumeracion.
 *************************************************************************
                             	MODIFICACIONES

 FECHA         		AUTOR          					COMENTARIOS
 Oct 10, 2021 	        renetravez					   	 Emisión Inicial
 ***************************************************************************/
package ec.advance.latam.com.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.advance.latam.com.mapper.IVacunaMapper;
import ec.advance.latam.com.service.IVacunaService;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * 
 * @author renetravez
 * @version $1.0$
 */
@RestController()
@RequestMapping("/api")
public class VacunaController {
	private static final Logger LOG = LoggerFactory.getLogger(VacunaController.class);
	@Autowired
	private IVacunaService vacunaService;
	@Autowired
	private IVacunaMapper vacunaMapper;
	private Map<String, Object> response;

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/vacunas")
	public ResponseEntity<?> listar() {
		try {
			return ResponseEntity.ok().body(vacunaMapper.listVacunaToListVacunaDto(vacunaService.findAll()));
		} catch (Exception e) {
			LOG.error("listar: ", e);
			response.put("mensaje", "Error al buscar el registro");
			response.put("error", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
