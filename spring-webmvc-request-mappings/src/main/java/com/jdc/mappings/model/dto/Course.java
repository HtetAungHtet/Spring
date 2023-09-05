package com.jdc.mappings.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Course {

	private int id;
	private String name;
	private String level;
	private int duration;
	private int fees;
	
	public Course(String name, String level, int duration, int fees) {
		super();
		this.name = name;
		this.level = level;
		this.duration = duration;
		this.fees = fees;
	}

}
