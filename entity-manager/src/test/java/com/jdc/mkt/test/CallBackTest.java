package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;

import com.jdc.demo.entity.Contact;

public class CallBackTest extends EmfCreation{

	@Test
	void test_create() {
		var em = emf.createEntityManager();
		var contact = new Contact();
		em.getTransaction().begin();
		
		contact.setPhone("099999999");
		contact.setAddress("Latha");
		contact.setEmail("latha@gmail.com");
		
		em.persist(contact);
		em.getTransaction().commit();
		
	}
	
	@Test
	void test_update() {
		var em = emf.createEntityManager();
		var contact = em.find(Contact.class, 1);
		
		em.getTransaction().begin();
		
		em.persist(contact);
		contact.setEmail("lathatal@gmail.com");
		
		em.getTransaction().commit();
	}
}
