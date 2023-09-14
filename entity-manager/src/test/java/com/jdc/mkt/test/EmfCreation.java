package com.jdc.mkt.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmfCreation {

	static EntityManagerFactory emf;

	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("em");
	}

	@AfterAll
	static void close() {
		if (null != emf && emf.isOpen()) {
			emf.close();
		}
	}
}
