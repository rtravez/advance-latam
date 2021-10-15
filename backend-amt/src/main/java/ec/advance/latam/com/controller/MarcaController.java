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

import ec.advance.latam.com.mapper.IMarcaMapper;
import ec.advance.latam.com.service.IMarcaService;

@RestController()
@RequestMapping("/api")
public class MarcaController {

	private static final Logger LOG = LoggerFactory.getLogger(MarcaController.class);
	@Autowired
	private IMarcaService marcaService;
	@Autowired
	private IMarcaMapper marcaMapper;
	private Map<String, Object> response;

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/marcas")
	public ResponseEntity<?> listar() {
		try {
			return ResponseEntity.ok().body(marcaMapper.listMarcaToListMarcaDto(marcaService.findAll()));
		} catch (Exception e) {
			LOG.error("listar: ", e);
			response.put("mensaje", "Error al buscar el registro");
			response.put("error", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
