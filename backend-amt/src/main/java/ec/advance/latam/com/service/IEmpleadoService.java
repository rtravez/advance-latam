package ec.advance.latam.com.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import ec.advance.latam.com.entity.Empleado;
import ec.advance.latam.com.exception.ExceptionManager;

public interface IEmpleadoService extends Serializable {

	public List<Empleado> findAll() throws ExceptionManager;

	public Optional<Empleado> findEmpleadoByCedula(String cedula) throws ExceptionManager;

	public Empleado save(Empleado empleado) throws ExceptionManager;

	public Empleado update(Empleado empleado) throws ExceptionManager;
}
