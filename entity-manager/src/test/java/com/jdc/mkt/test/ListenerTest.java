package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;

import com.jdc.demo.entity.Contact;
import com.jdc.demo.entity.Member;

public class ListenerTest extends EmfCreation{

	@Test
	void test_create() {
		var em = emf.createEntityManager();
		var member = new Member("Thidar", "Thidar", "123");
		em.getTransaction().begin();
		em.persist(member);
		em.getTransaction().commit();
		
	}
	
	@Test
	void test_update() {
		var em = emf.createEntityManager();
		var member = em.find(Member.class, 1);
		
		em.getTransaction().begin();
		
		em.persist(member);
		member.setName("hah");
		
		em.getTransaction().commit();
	}
}
