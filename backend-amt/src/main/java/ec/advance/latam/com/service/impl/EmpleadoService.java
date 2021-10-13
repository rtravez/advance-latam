package ec.advance.latam.com.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ec.advance.latam.com.dao.IEmpleadoDao;
import ec.advance.latam.com.dao.IRoleDao;
import ec.advance.latam.com.entity.Empleado;
import ec.advance.latam.com.entity.Role;
import ec.advance.latam.com.entity.RolesUsuario;
import ec.advance.latam.com.entity.Usuario;
import ec.advance.latam.com.exception.ExceptionManager;
import ec.advance.latam.com.service.IEmpleadoService;
import ec.advance.latam.com.service.IRolesUsuarioService;
import ec.advance.latam.com.service.IUsuarioService;
import ec.advance.latam.com.utility.Utilities;

@Scope("singleton")
@Service("EmpleadoService")
public class EmpleadoService implements IEmpleadoService {
	private static final Logger LOG = LoggerFactory.getLogger(EmpleadoService.class);

	private static final long serialVersionUID = 1L;
	@Autowired
	private IEmpleadoDao empleadoDao;
	@Autowired
	private IRoleDao roleDao;
	@Autowired
	IRolesUsuarioService rolesUsuarioService;
	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private transient BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional(readOnly = true)
	public Optional<Empleado> findEmpleadoByCedula(String cedula) throws ExceptionManager {
		try {
			return empleadoDao.findEmpleadoByCedula(cedula);
		} catch (Exception e) {
			LOG.error("findEmpleadoByNombre: ", e);
			throw new ExceptionManager().new FindingException("Error al buscar el registro");
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = ExceptionManager.class)
	public Empleado save(Empleado empleado) throws ExceptionManager {
		try {
			if (empleado == null) {
				throw new ExceptionManager().new NullEntityExcepcion("Empleados");
			}

			if (empleadoDao.findEmpleadoByCedula(empleado.getCedula()).isPresent()) {
				throw new ExceptionManager().new FindingException("La cedula " + empleado.getCedula() + " ya existe ");
			}
			if (!Utilities.isCedulaValido(empleado.getCedula())) {
				throw new ExceptionManager().new GettingException("La cedula " + empleado.getCedula() + " es incorrecta ");
			}

			if (!Utilities.isValidEmail(empleado.getCorreo())) {
				throw new ExceptionManager().new GettingException("El correo " + empleado.getCorreo() + " es incorrecto ");
			}

			Role role = roleDao.findRoleByNombre("ROLE_USER");
			Usuario usuario = usuarioService.save(new Usuario(empleado.getCedula(), passwordEncoder.encode(empleado.getCedula()), true));
			rolesUsuarioService.save(new RolesUsuario(role, usuario, true));

			empleado.setUsuario(usuario);
			return empleadoDao.save(empleado);
		} catch (ExceptionManager ex) {
			throw ex;
		} catch (Exception e) {
			LOG.error("save: ", e);
			throw new ExceptionManager().new GettingException("Error al guardar el registro");
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = ExceptionManager.class)
	public Empleado update(Empleado empleado) throws ExceptionManager {
		try {
			if (empleado == null) {
				throw new ExceptionManager().new NullEntityExcepcion("Empleados");
			}

			Optional<Empleado> e = empleadoDao.findEmpleadoByCedula(empleado.getCedula());
			if (e.isPresent()) {
				e.get().setFechaNacimiento(empleado.getFechaNacimiento());
				e.get().setDireccion(empleado.getDireccion());
				e.get().setCelular(empleado.getCelular());
				e.get().setVacunado(empleado.getVacunado());

			} else
				throw new ExceptionManager().new FindingException("La cedula " + empleado.getCedula() + " no existe ");

			return empleadoDao.save(e.get());
		} catch (ExceptionManager ex) {
			throw ex;
		} catch (Exception e) {
			LOG.error("update: ", e);
			throw new ExceptionManager().new GettingException("Error al actualizar el registro");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll() throws ExceptionManager {
		try {
			return empleadoDao.findAll();
		} catch (Exception e) {
			LOG.error("findAll: ", e);
			throw new ExceptionManager().new FindingException("Error al buscar el registro");
		}
	}
}
