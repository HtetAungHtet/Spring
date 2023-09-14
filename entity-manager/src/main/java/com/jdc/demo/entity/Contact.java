package com.jdc.demo.entity;

import com.jdc.demo.entity.listeners.Times;
import com.jdc.demo.entity.listeners.TimesEnableEntity;
import com.jdc.demo.entity.listeners.TimesListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
@EntityListeners(TimesListener.class)
public class Contact implements TimesEnableEntity{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 12,unique = true)
	private String phone;
	@Column(nullable = false)
	private String email;
	private String address;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Member member;

	private Times times;
	
	public Contact() {
		
	}
	
	public Contact(String phone, String email, String address) {
		super();
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	
//	@PrePersist
//	public void beforeCreate() {
//		creation = LocalDateTime.now();
//		System.out.println("Create Contact");
//	}
//	
//	@PreUpdate
//	public void beforeUpdate() {
//		modification = LocalDateTime.now();
//		System.out.println("Update Contact");
//	}
}
