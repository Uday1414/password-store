package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.UserDto;

public class UserDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");

	public UserDto saveUser(UserDto userDto) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(userDto);
		entityTransaction.commit();
		return userDto;
	}

	public UserDto validateUser(String email, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("SELECT u FROM UserDto u WHERE u.email=?1 AND u.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<UserDto> users = query.getResultList();
		return users.get(0);
	}
}
