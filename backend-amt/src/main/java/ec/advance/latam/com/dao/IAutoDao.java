package ec.advance.latam.com.dao;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.advance.latam.com.entity.Auto;
import ec.advance.latam.com.exception.ExceptionManager;

public interface IAutoDao extends JpaRepository<Auto, Long>, Serializable {

	//@Query("select a from Auto a join fetch a.marca m join fetch a.tipo t where a.placa = ?1")
	public Optional<Auto> findAutoByPlaca(String placa) throws ExceptionManager;

}
