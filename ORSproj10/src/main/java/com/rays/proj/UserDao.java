package com.rays.proj;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao<t extends UserDto> {

	@PersistenceContext
	public EntityManager entityManager;

	public long add(UserDto dto) {
		entityManager.persist(dto);
		return dto.getId();
	}

	public UserDto findById(long id) {
		return entityManager.find(UserDto.class, id);

	}

	public UserDto update(UserDto dto) {
		return entityManager.merge(dto);

	}

	public List search(UserDto dto) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserDto> cq = builder.createQuery(UserDto.class);
		Root<UserDto> qroot = cq.from(UserDto.class);
		// cq.select(qroot);

		Predicate con = builder.equal(qroot.get("firstName"), dto.getFirstName());
		cq.where(con);

		TypedQuery<UserDto> query = entityManager.createQuery(cq);
		List list = query.getResultList();

		return list;

	}

}
