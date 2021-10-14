package ec.advance.latam.com.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.advance.latam.com.entity.Marca;

public interface IMarcaDao extends JpaRepository<Marca, Long>, Serializable {

}
