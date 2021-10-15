package ec.advance.latam.com.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import ec.advance.latam.com.entity.Marca;
import ec.advance.latam.com.entity.Modelo;
import ec.advance.latam.com.exception.ExceptionManager;

public interface IModeloService extends Serializable {

	public List<Modelo> findModeloByMarca(Marca marca) throws ExceptionManager;

	public Optional<Modelo> findById(Long id) throws ExceptionManager;

}
