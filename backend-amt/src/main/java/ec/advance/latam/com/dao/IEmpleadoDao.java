package ec.advance.latam.com.dao;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ec.advance.latam.com.entity.Empleado;
import ec.advance.latam.com.exception.ExceptionManager;

public interface IEmpleadoDao extends Serializable, JpaRepository<Empleado, Long> {

	@Query("select e from Empleado e where e.cedula like %?1%")
	public Optional<Empleado> findEmpleadoByCedula(String cedula) throws ExceptionManager;

}
