package com.jdc.mappings.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("inputs")
public class InputControllers {

	@RequestMapping
	public void index(ModelMap model) {
		model.put("message", "User INPUTs");
	}

	// inputs/type?/search/id?
	@GetMapping("{type}/search/{id:\\d+}")
	public String usingPath(
			@PathVariable String type,
			@PathVariable Integer id,
			Model model) {
		model.addAttribute("type", type);
		model.addAttribute("id", id);
		return "inputs";
	}
	
	@GetMapping("{date:\\d{4}\\-\\d{2}\\-\\d{2}}")
	public String dateVar(
			@PathVariable 
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			LocalDate date,
			Model model) {
		model.addAttribute("date", date);
		return "inputs";
	}
	
	@GetMapping("{level:Basic|Intermediate|Advance}")
	public String UsingEnum(
			@PathVariable Level level,
			Model model) {
		model.addAttribute("date", level );
		return "inputs";
	}
	
	@GetMapping("matrix/{product}")
	public String UsingMatrix(
			@PathVariable String product,
			@MatrixVariable(name = "s" , pathVar = "product") String size,
			@MatrixVariable(required = false , defaultValue = "100") int id,
			Model model) {
		var message = "product : %s , size : %s , id : %d".formatted(product,size,id);
		model.addAttribute("date", message);
		return "inputs";
	}
	
	@GetMapping("request")
	public String UsingRequest(
			@RequestParam("p") String product,
			@RequestParam(name = "w", defaultValue = "11" , required = false) int width,
			@RequestParam(name = "l" , defaultValue = "11" , required = false) int length,
			Model model) {
		var message = "product : %s , width : %d , length : %d".formatted(product,width,length);
		model.addAttribute("date", message);
		return "inputs";
	}
}
