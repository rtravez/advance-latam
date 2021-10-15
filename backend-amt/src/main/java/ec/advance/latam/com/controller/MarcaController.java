package ec.advance.latam.com.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

import ec.advance.latam.com.entity.Tipo;
import ec.advance.latam.com.mapper.IMarcaMapper;
import ec.advance.latam.com.service.IMarcaService;
import ec.advance.latam.com.service.ITipoService;

@RestController()
@RequestMapping("/api")
public class MarcaController {

	private static final Logger LOG = LoggerFactory.getLogger(MarcaController.class);
	@Autowired
	private ITipoService tipoService;
	@Autowired
	private IMarcaService marcaService;
	@Autowired
	private IMarcaMapper marcaMapper;
	private Map<String, Object> response;

	public MarcaController() {
		response = new HashMap<>(); 
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/marcas/{tipo}")
	public ResponseEntity<?> findMarcaByTipo(@PathVariable Long tipo) {
		try {
			Optional<Tipo> t = tipoService.findById(tipo);
			if (t.isPresent())
				return ResponseEntity.ok()
						.body(marcaMapper.listMarcaToListMarcaDto(marcaService.findMarcaByTipo(t.get())));
			else {
				response.put("mensaje", "La marca por tipo no existe");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			LOG.error("listar: ", e);
			response.put("mensaje", "Error al buscar el registro");
			response.put("error", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
