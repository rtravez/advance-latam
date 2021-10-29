package ec.advance.latam.com.service;

import java.io.Serializable;
import java.util.Optional;

import ec.advance.latam.com.entity.Auto;
import ec.advance.latam.com.exception.ExceptionManager;

public interface IAutoService extends IGenericService<Auto, Long>, Serializable {

	public Optional<Auto> findAutoByPlaca(String placa) throws ExceptionManager;

	public boolean findHoyNoCircula(String placa, String fecha) throws ExceptionManager;

}
