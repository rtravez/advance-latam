package ec.advance.latam.com.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ec.advance.latam.com.dao.IAutoDao;
import ec.advance.latam.com.entity.Auto;
import ec.advance.latam.com.exception.ExceptionManager;
import ec.advance.latam.com.service.IAutoService;

@Scope("singleton")
@Service("AutoService")
public class AutoService implements IAutoService {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LoggerFactory.getLogger(AutoService.class);

	@Autowired
	private IAutoDao autoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Auto> findAll() throws ExceptionManager {
		try {
			return autoDao.findAll();
		} catch (Exception e) {
			LOG.error("findAll: ", e);
			throw new ExceptionManager().new FindingException("Error al buscar los registros");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existsById(Long id) throws ExceptionManager {
		try {
			return autoDao.existsById(id);
		} catch (Exception e) {
			LOG.error("existsById: ", e);
			throw new ExceptionManager().new FindingException("Error al buscar el registro");
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Auto> findById(Long id) throws ExceptionManager {
		try {
			return autoDao.findById(id);
		} catch (Exception e) {
			LOG.error("findById: ", e);
			throw new ExceptionManager().new FindingException("Error al buscar el registro");
		}

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = ExceptionManager.class)
	public void delete(Auto auto) throws ExceptionManager {
		try {
			autoDao.delete(auto);
		} catch (Exception e) {
			LOG.error("delete: ", e);
			throw new ExceptionManager().new GettingException("Error al eliminar el registro");
		}

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = ExceptionManager.class)
	public Auto save(Auto auto) throws ExceptionManager {
		try {
			if (autoDao.findAutoByPlaca(auto.getPlaca()).isPresent())
				throw new ExceptionManager().new FindingException("La placa ya existe");

			if (autoDao.findAutoByChasis(auto.getChasis()).isPresent())
				throw new ExceptionManager().new FindingException("El chasis ya existe");

			return autoDao.save(auto);
		} catch (ExceptionManager e) {
			throw e;
		} catch (Exception e) {
			LOG.error("save: ", e);
			throw new ExceptionManager().new GettingException("Error al guardar el registro");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Auto> findAutoByPlaca(String placa) throws ExceptionManager {
		try {
			return autoDao.findAutoByPlaca(placa);
		} catch (Exception e) {
			LOG.error("findAutoByPlaca: ", e);
			throw new ExceptionManager().new FindingException("Error al buscar el registro");
		}
	}
}
