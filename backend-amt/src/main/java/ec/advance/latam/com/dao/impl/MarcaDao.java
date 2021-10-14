package ec.advance.latam.com.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.stereotype.Repository;

import ec.advance.latam.com.dao.IMarcaDao;
import ec.advance.latam.com.entity.Marca;

@Repository("MarcaDao")
public class MarcaDao extends ExtendedRepositoryImpl<Marca, Long> implements IMarcaDao {

	

	@Autowired
	private EntityManager entityManager;

	public MarcaDao(JpaEntityInformation<Marca, Long> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}
	public MarcaDao(EntityManager entityManager) {
		super(em);
	}
	
	@Override
	public void delete(Marca entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public void deleteByIdiiiiiiiiiii(Long id) {
		
		
	}

}
