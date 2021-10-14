package ec.advance.latam.com.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import ec.advance.latam.com.entity.Auto;
import ec.advance.latam.com.exception.ExceptionManager;

public interface IAutoService extends Serializable {

	public boolean existsById(Long id) throws ExceptionManager;

	public Optional<Auto> findById(Long id) throws ExceptionManager;

	public List<Auto> findAll() throws ExceptionManager;

	public void delete(Auto auto) throws ExceptionManager;

	public void save(Auto auto) throws ExceptionManager;

	public Optional<Auto> findAutoByPlaca(String placa) throws ExceptionManager;

}
