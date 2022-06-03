package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.DetailsDto;
import com.ty.dto.UserDto;

public class DetailsDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	
	public DetailsDto saveDetails(DetailsDto detailsDto , int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		UserDto userDto = entityManager.find(UserDto.class,id);
		detailsDto.setUserDto(userDto);
		entityTransaction.begin();
		entityManager.persist(detailsDto);
		entityTransaction.commit();
		return detailsDto;
	}
	
	public List<DetailsDto> getByUserId(int id){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT d FROM DetailsDto d WHERE d.userDto.id=?1");
		query.setParameter(1, id);
		return query.getResultList();
		
	}
}
