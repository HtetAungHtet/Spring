package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.demo.entity.Contact;

public class FetchModeTest extends EmfCreation{

	@ParameterizedTest
	@ValueSource(ints = 1)
	void test(int id) {
		var em = emf.createEntityManager();
		var contact = em.find(Contact.class, id);
		
		em.close();
		
		assertThrows(LazyInitializationException.class, contact.getMember()::getName);
	}
}
