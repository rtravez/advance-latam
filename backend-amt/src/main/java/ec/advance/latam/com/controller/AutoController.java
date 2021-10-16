package ec.advance.latam.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.advance.latam.com.dto.AutoDto;
import ec.advance.latam.com.entity.Auto;
import ec.advance.latam.com.mapper.IAutoMapper;
import ec.advance.latam.com.service.IAutoService;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * 
 * @author rene.travez
 * @version $1.0$
 */
@RestController()
@RequestMapping("/api")
public class AutoController {

	private static final Logger LOG = LoggerFactory.getLogger(AutoController.class);

	@Autowired
	private IAutoService autoService;
	@Autowired
	private IAutoMapper autoMapper;
	private Map<String, Object> response;

	public AutoController() {
		response = new HashMap<>();
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/autos/{placa}")
	public ResponseEntity<?> findAutoByPlaca(@PathVariable String placa) {
		try {
			Optional<Auto> a = autoService.findAutoByPlaca(placa);
			if (a.isPresent())
				return ResponseEntity.ok().body(autoMapper.autoToAutoDto(a.get()));
			else {
				response.put("mensaje", "El auto por placa no existe");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			LOG.error("listar: ", e);
			response.put("mensaje", "Error al buscar el registro");
			response.put("error", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Secured({ "ROLE_ADMIN" })
	@PostMapping("/autos")
	public ResponseEntity<?> create(@Valid @RequestBody AutoDto autoDto, BindingResult result) {
		response = new HashMap<>();
		try {
			if (result.hasErrors()) {
				List<String> errors = result.getFieldErrors().stream()
						.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
						.collect(Collectors.toList());
				response.put("errors", errors);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}

			Auto auto = autoMapper.autoDtoToAuto(autoDto);
			auto = autoService.save(auto);
			response.put("mensaje", "El auto ha sido creado con éxito");
			response.put("empleado", autoMapper.autoToAutoDto(auto));
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (Exception e) {
			response.put("mensaje", "Error al guardar el registro");
			response.put("error", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
