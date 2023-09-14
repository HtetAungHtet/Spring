package com.jdc.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.jdc.demo.entity.listeners.Times;
import com.jdc.demo.entity.listeners.TimesEnableEntity;
import com.jdc.demo.entity.listeners.TimesListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
@EntityListeners(TimesListener.class)
public class Member implements TimesEnableEntity{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(unique = true, nullable = false)
	private String loginId;
	@Column(nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(mappedBy = "member", orphanRemoval = true, cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Contact> contacts;
	
	@ElementCollection
	private List<String> tags;
	
	private Times times;
	
	public enum Role{
		ADMIN , MEMBER
	}
	
	public Member() {
		tags = new ArrayList<>();
		contacts = new ArrayList<>();
	}
	
	public void addContact(Contact c) {
		c.setMember(this);
		contacts.add(c);
	}
	
	public Member(String name, String loginId, String password) {
		this();
		this.name = name;
		this.loginId = loginId;
		this.password = password;
		this.role = Role.MEMBER;
	}

}
