package com.jdc.demo.entity.listeners;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class Times {

	private LocalDateTime creation;
	private LocalDateTime modification;
	
}
