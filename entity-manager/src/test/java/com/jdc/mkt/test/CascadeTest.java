package com.jdc.mkt.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.demo.entity.Contact;
import com.jdc.demo.entity.Member;

public class CascadeTest extends EmfCreation{

	@ParameterizedTest
	@CsvSource("htet aung,hah,12399,0926442743,haha@gmail.com,Pazantaung")
	void test(String name, String loginId, String password, String phone, String email, String address) {
		
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		var member = new Member(name, loginId, password);
		var contact = new Contact(phone, email, address);
		member.addContact(contact);
		
		em.persist(member);
		
		em.getTransaction().commit();
	}
}
