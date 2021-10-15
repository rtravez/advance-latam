package ec.advance.latam.com.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.advance.latam.com.dao.IModeloDao;
import ec.advance.latam.com.entity.Marca;
import ec.advance.latam.com.entity.Modelo;
import ec.advance.latam.com.exception.ExceptionManager;
import ec.advance.latam.com.service.IModeloService;

@Scope("singleton")
@Service("ModeloService")
public class ModeloService implements IModeloService {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(ModeloService.class);
	@Autowired
	private IModeloDao modeloDao;

	@Override
	@Transactional(readOnly = true)
	public List<Modelo> findModeloByMarca(Marca marca) throws ExceptionManager {
		try {
			return modeloDao.findModeloByMarca(marca);
		} catch (Exception e) {
			LOG.error("findAll: ", e);
			throw new ExceptionManager().new FindingException("Error al buscar los registros");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Modelo> findById(Long id) throws ExceptionManager {
		try {
			return modeloDao.findById(id);
		} catch (Exception e) {
			LOG.error("findById: ", e);
			throw new ExceptionManager().new FindingException("Error al buscar el registro");
		}
	}
}
