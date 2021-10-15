package ec.advance.latam.com.controller;

import java.util.HashMap;
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

import ec.advance.latam.com.mapper.ITipoMapper;
import ec.advance.latam.com.service.ITipoService;

@RestController()
@RequestMapping("/api")
public class TipoController {

	private static final Logger LOG = LoggerFactory.getLogger(TipoController.class);
	@Autowired
	private ITipoService tipoService;
	@Autowired
	private ITipoMapper tipoMapper;
	private Map<String, Object> response;
	public TipoController() {
		response = new HashMap<>();
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/tipos")
	public ResponseEntity<?> listar() {
		try {
			return ResponseEntity.ok().body(tipoMapper.listTipoToListTipoDto(tipoService.findAll()));
		} catch (Exception e) {
			LOG.error("listar: ", e);
			response.put("mensaje", "Error al buscar el registro");
			response.put("error", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
