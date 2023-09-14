package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.demo.entity.Member;

import jakarta.persistence.PersistenceException;

public class PersistOperationTest extends EmfCreation{

	@ParameterizedTest
	@CsvSource("2,Htet Aung,htetaung,123")
	void test_persist_to_transient_state(int id, String name, String loginId, String password) {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		var member = new Member(name, loginId, password);
		assertFalse(em.contains(member));
		
		em.persist(member);
		assertEquals(id, member.getId());
		
		assertTrue(em.contains(member));
		
		em.getTransaction().commit();
	}
	
	@ParameterizedTest
	@ValueSource(ints = 1)
	void test_persist_to_managed_state(int id) {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		var member = em.find(Member.class, id);
		assertTrue(em.contains(member));
		
		assertDoesNotThrow(() -> em.persist(member));
		
		assertTrue(em.contains(member));
		em.getTransaction().commit();
	}
	
	@ParameterizedTest
	@ValueSource(ints = 1)
	void test_persist_to_detached_state(int id) {
		var em = emf.createEntityManager();
		
		var member = em.find(Member.class, id);
		em.detach(member);
		
		assertFalse(em.contains(member));
		
		assertThrows(PersistenceException.class, () -> {
			em.getTransaction().begin();
			em.persist(member);
			em.getTransaction().commit();
		});
	}
	
	@ParameterizedTest
	@ValueSource(ints = 1)
	void test_persist_to_remove_state(int id) {
		var em = emf.createEntityManager();

		var member = em.find(Member.class, id);
		em.getTransaction().begin();
		
		em.remove(member);
		
		assertDoesNotThrow(()-> {
			em.persist(member);
			em.getTransaction().commit();
			
			assertTrue(em.contains(member));
		});
	}
}
