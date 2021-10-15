package ec.advance.latam.com.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.advance.latam.com.dao.IMarcaDao;
import ec.advance.latam.com.entity.Marca;
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
	public List<Marca> findAll() throws ExceptionManager {
		try {
			return marcaDao.findAll();
		} catch (Exception e) {
			LOG.error("findAll: ", e);
			throw new ExceptionManager().new FindingException("Error al buscar los registros");
		}
	}
}
