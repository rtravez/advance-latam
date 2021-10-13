package ec.advance.latam.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.advance.latam.com.dto.EmpleadoDto;
import ec.advance.latam.com.entity.Empleado;
import ec.advance.latam.com.mapper.IEmpleadoMapper;
import ec.advance.latam.com.service.IEmpleadoService;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * 
 * @author rene.travez
 * @version $1.0$
 */
@RestController()
@RequestMapping("/api")
public class EmpleadoController {

	private static final Logger LOG = LoggerFactory.getLogger(EmpleadoController.class);

	@Autowired
	private IEmpleadoService empleadoService;
	@Autowired
	private IEmpleadoMapper empleadoMapper;
	private Map<String, Object> response;

	public EmpleadoController() {
		response = new HashMap<>();
	}

	@Secured({ "ROLE_ADMIN" })
	@GetMapping("/empleados/{cedula}")
	public ResponseEntity<?> findEmpleadoByCedula(@PathVariable String cedula) {
		response = new HashMap<>();
		try {
			Empleado empleado = empleadoService.findEmpleadoByCedula(cedula).orElse(null);

			if (empleado == null) {
				response.put("mensaje", "El empleado no existe");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
			return ResponseEntity.ok().body(empleadoMapper.empleadoToEmpleadoDto(empleado));
		} catch (Exception e) {
			LOG.error("findEmpleadoByCedula: ", e);
			response.put("mensaje", "Error al realizar la consulta");
			response.put("error", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Secured({ "ROLE_ADMIN" })
	@GetMapping("/empleados")
	public ResponseEntity<?> findAll() {
		response = new HashMap<>();
		try {
			List<Empleado> empleados = empleadoService.findAll();

			if (empleados.isEmpty()) {
				response.put("mensaje", "Los empleados no existen");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
			return ResponseEntity.ok().body(empleadoMapper.listEmpleadoToListEmpleadoDto(empleados));
		} catch (Exception e) {
			LOG.error("findAll: ", e);
			response.put("mensaje", "Error al realizar la consulta");
			response.put("error", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Secured({ "ROLE_ADMIN" })
	@PostMapping("/empleados")
	public ResponseEntity<?> create(@Valid @RequestBody EmpleadoDto empleadoDto, BindingResult result) {
		response = new HashMap<>();
		try {
			if (result.hasErrors()) {
				List<String> errors = result.getFieldErrors().stream().map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage()).collect(Collectors.toList());
				response.put("errors", errors);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}

			Empleado empleado = empleadoMapper.empleadoDtoToEmpleado(empleadoDto);
			empleado = empleadoService.save(empleado);
			response.put("mensaje", "El empleado ha sido creado con éxito");
			response.put("empleado", empleadoMapper.empleadoToEmpleadoDto(empleado));
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (Exception e) {
			response.put("mensaje", "Error al guardar el registro");
			response.put("error", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Secured({ "ROLE_USER" })
	@PatchMapping("/empleados/{cedula}")
	public ResponseEntity<?> update(@Valid @RequestBody EmpleadoDto empleadoDto, BindingResult result, @PathVariable String cedula) {
		response = new HashMap<>();
		try {
			if (result.hasErrors()) {
				List<String> errors = result.getFieldErrors().stream().map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage()).collect(Collectors.toList());
				response.put("errors", errors);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			Empleado empleado = empleadoMapper.empleadoDtoToEmpleado(empleadoDto);
			empleado = empleadoService.update(empleado);
			response.put("mensaje", "El empleado ha sido actualizado con éxito");
			response.put("empleado", empleadoMapper.empleadoToEmpleadoDto(empleado));
			return ResponseEntity.status(HttpStatus.CREATED).body(response);

		} catch (Exception e) {
			response.put("mensaje", "Error al actualizar el registro");
			response.put("error", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
