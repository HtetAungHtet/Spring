package com.jdc.mappings.model.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Result {

	private String message;
	private Status status;
	
	public enum Status{
		Success , Warning , Error
	}
	
}
