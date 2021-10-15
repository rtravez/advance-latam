package ec.advance.latam.com.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.advance.latam.com.dao.ITipoDao;
import ec.advance.latam.com.entity.Tipo;
import ec.advance.latam.com.exception.ExceptionManager;
import ec.advance.latam.com.service.ITipoService;

@Scope("singleton")
@Service("TipoService")
public class TipoService implements ITipoService {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(TipoService.class);
	@Autowired
	private ITipoDao tipoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Tipo> findAll() throws ExceptionManager {
		try {
			return tipoDao.findAll();
		} catch (Exception e) {
			LOG.error("findAll: ", e);
			throw new ExceptionManager().new FindingException("Error al buscar los registros");
		}
	}
}
