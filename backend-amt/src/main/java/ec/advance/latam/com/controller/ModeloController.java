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

import ec.advance.latam.com.entity.Marca;
import ec.advance.latam.com.mapper.IModeloMapper;
import ec.advance.latam.com.service.IMarcaService;
import ec.advance.latam.com.service.IModeloService;

@RestController()
@RequestMapping("/api")
public class ModeloController {

	private static final Logger LOG = LoggerFactory.getLogger(ModeloController.class);
	@Autowired
	private IModeloService modeloService;
	@Autowired
	private IMarcaService marcaService;
	@Autowired
	private IModeloMapper modeloMapper;
	private Map<String, Object> response;

	public ModeloController() {
		response = new HashMap<>();
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/modelos/{marca}")
	public ResponseEntity<?> findModeloByMarca(@PathVariable Long marca) {
		try {
			Optional<Marca> m = marcaService.findById(marca);
			if (m.isPresent())
				return ResponseEntity.ok().body(modeloMapper.listModeloToListModeloDto(modeloService.findModeloByMarca(m.get())));
			else {
				response.put("mensaje", "El modelo por marca no existe");
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
