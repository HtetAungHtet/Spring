package com.jdc.demo.entity.listeners;

import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class TimesListener {

	@PrePersist
	void test_create(Object object) {
		System.out.println("Before Create");
		if(object instanceof TimesEnableEntity ent) {
			var times = ent.getTimes();
			if(null == times) {
				times = new Times();
				ent.setTimes(times);
			}
			times.setCreation(LocalDateTime.now());
		}
	}
	
	@PreUpdate
	void test_update(Object object) {
		System.out.println("Before Update");
		if(object instanceof TimesEnableEntity ent) {
			var times = ent.getTimes();
			if(null == times) {
				times = new Times();
				ent.setTimes(times);
			}
			times.setModification(LocalDateTime.now());
		}
	}
}
