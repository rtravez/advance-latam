package ec.advance.latam.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.advance.latam.com.entity.Auto;

public interface IAutoDao extends JpaRepository<Auto, Integer> {

}
