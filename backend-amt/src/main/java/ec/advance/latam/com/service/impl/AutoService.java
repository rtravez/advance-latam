package ec.advance.latam.com.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
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

}
