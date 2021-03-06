package ec.advance.latam.com.service.impl;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ec.advance.latam.com.dao.IAutoDao;
import ec.advance.latam.com.dao.IGenericDao;
import ec.advance.latam.com.dao.IRestriccionDao;
import ec.advance.latam.com.entity.Auto;
import ec.advance.latam.com.entity.Restriccion;
import ec.advance.latam.com.exception.ExceptionManager;
import ec.advance.latam.com.service.IAutoService;
import ec.advance.latam.com.utility.Constantes;
import ec.advance.latam.com.utility.Utilities;

@Scope("singleton")
@Service("AutoService")
public class AutoService extends GenericService<Auto, Long> implements IAutoService {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(AutoService.class);

	@Autowired
	private IAutoDao autoDao;
	@Autowired
	private IRestriccionDao restriccionDao;

	public AutoService() {
	}

	@Autowired
	public AutoService(IGenericDao<Auto, Long> genericDao) {
		super(genericDao);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = ExceptionManager.class)
	public Auto save(Auto auto) throws ExceptionManager {
		try {
			if (autoDao.findAutoByPlaca(auto.getPlaca()).isPresent())
				throw new ExceptionManager().new FindingException("La placa ya existe");

			if (autoDao.findAutoByChasis(auto.getChasis()).isPresent())
				throw new ExceptionManager().new FindingException("El chasis ya existe");

			return super.save(auto);
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

	@Override
	@Transactional(readOnly = true)
	public boolean findHoyNoCircula(String placa, String fecha) throws ExceptionManager {
		try {
			String ultimoDigito;
			Date f = Utilities.convertirDateStringToDate(fecha, Constantes.FORMATO_FECHA);
			Date fa = Utilities.convertirDateStringToDate(Utilities.convertirDateToDateString(new Date(), Constantes.FORMATO_FECHA), Constantes.FORMATO_FECHA);

			if (f.getTime() < fa.getTime())
				throw new ExceptionManager().new GettingException("La fecha no puede ser menor a la fecha actual: " + Utilities.convertirDateToDateString(fa, Constantes.FORMATO_FECHA));

			Optional<Restriccion> restriccion = restriccionDao.findRestriccionByValorEntero(Long.valueOf(Utilities.dayOfWeek(f)));

			if (restriccion.isPresent()) {
				String diasNocircula[] = restriccion.get().getValorCadena().split(",");
				if (diasNocircula.length > 0) {
					if (placa.trim().length() == Constantes.FORMATO_PLACA7) {
						ultimoDigito = placa.substring(6, 7);
						for (int x = 0; x < diasNocircula.length; x++) {
							if (diasNocircula[x].equals(ultimoDigito)) {
								throw new ExceptionManager().new GettingException("El auto con placa " + placa + " no puede circular por su ultimo digito verificador " + ultimoDigito);
							}
						}
					} else if (placa.trim().length() == Constantes.FORMATO_PLACA8) {
						ultimoDigito = placa.substring(7, 8);
						for (int x = 0; x < diasNocircula.length; x++) {
							if (diasNocircula[x].equals(ultimoDigito)) {
								throw new ExceptionManager().new GettingException("El auto con placa " + placa + " no puede circular por su ultimo digito verificador " + ultimoDigito);
							}
						}
					} else {
						throw new ExceptionManager().new GettingException("El formato de la placa no se cumple: ");
					}
				}
			}
			return true;
		} catch (ExceptionManager e) {
			throw e;
		} catch (Exception e) {
			LOG.error("findAutoByPlaca: ", e);
			throw new ExceptionManager().new GettingException("Error al validar hoy no circula");
		}
	}
}
