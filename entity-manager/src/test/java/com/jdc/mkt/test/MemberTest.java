package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.demo.entity.Member;
import com.jdc.demo.entity.Member.Role;

import jakarta.persistence.EntityNotFoundException;

@TestMethodOrder(OrderAnnotation.class)
public class MemberTest extends EmfCreation{


	@Order(1)
	@ParameterizedTest
	@CsvSource(value = "Htet Aung Htet:hah:123", delimiter = ':')
	void test(String name, String loginId, String password) {
		var em = emf.createEntityManager();
		// Transient State
		var member = new Member(name, loginId, password);

		em.getTransaction().begin();

		// To be managed
		em.persist(member);
		assertTrue(em.contains(member));
		// em.detach(member);
		em.clear();
		assertFalse(em.contains(member));

		member.setRole(Role.ADMIN);

		member = em.merge(member);
		em.merge(member);

		em.getTransaction().commit();
	}

	@Order(2)
	@ParameterizedTest
	@ValueSource(ints = 1)
	void test_find(int id) {
		var em = emf.createEntityManager();
		var member = em.find(Member.class, id);
		
		assertNotNull(member);
		assertTrue(em.contains(member));
		
		em.detach(member);
		
		assertAll(
				()-> assertEquals("Admin User", member.getName()),
				()-> assertEquals("admin", member.getLoginId()),
				()-> assertEquals(Role.ADMIN, member.getRole())
				);
	}
	
	@Order(3)
	@ParameterizedTest
	@ValueSource(ints = 1)
	void test_getReference(int id) {
		var em = emf.createEntityManager();
		var member = em.getReference(Member.class, id);
		
		assertNotNull(member);
		assertTrue(em.contains(member));
		
		em.detach(member);
		
		assertAll(
				()-> assertThrows(LazyInitializationException.class, member::getName),
				()-> assertThrows(LazyInitializationException.class, member::getLoginId),
				()-> assertThrows(LazyInitializationException.class, member::getRole)
				);
	}
	
	@Order(4)
	@ParameterizedTest
	@ValueSource(ints = 3)
	void test_find_not_found(int id) {
		var em = emf.createEntityManager();
		var member = em.find(Member.class, id);
		
		assertNull(member);
	}
	
	@Order(5)
	@ParameterizedTest
	@ValueSource(ints = 3)
	void test_getReference_not_found(int id) {
		var em = emf.createEntityManager();
		var member = em.getReference(Member.class, id);
		
		assertNotNull(member);
		assertThrows(EntityNotFoundException.class, member::getName);

	}
	
	@Order(6)
	@ParameterizedTest
	@ValueSource(ints = 1)
	void test_lazy_fetch(int id) {
		var em = emf.createEntityManager();
		var member = em.find(Member.class, id);
		
		assertNotNull(member);
		em.detach(member);
		
		assertThrows(LazyInitializationException.class,() -> member.getTags().size());
	}
}
