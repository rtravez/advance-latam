package ec.advance.latam.com.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.advance.latam.com.dao.IMarcaDao;
import ec.advance.latam.com.entity.Marca;
import ec.advance.latam.com.entity.Tipo;
import ec.advance.latam.com.exception.ExceptionManager;
import ec.advance.latam.com.service.IMarcaService;

@Scope("singleton")
@Service("MarcaService")
public class MarcaService implements IMarcaService {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(MarcaService.class);
	@Autowired
	private IMarcaDao marcaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Marca> findMarcaByTipo(Tipo tipo) throws ExceptionManager {
		try {
			return marcaDao.findMarcaByTipo(tipo);
		} catch (Exception e) {
			LOG.error("findAll: ", e);
			throw new ExceptionManager().new FindingException("Error al buscar los registros");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Marca> findById(Long id) throws ExceptionManager {
		try {
			return marcaDao.findById(id);
		} catch (Exception e) {
			LOG.error("findById: ", e);
			throw new ExceptionManager().new FindingException("Error al buscar el registro");
		}
	}
}
