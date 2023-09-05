package com.jdc.mappings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("multi")
public class MultiControllers {

	@RequestMapping
	public void index(Model model) {
		model.addAttribute("message", "Do Multi Actions");
	}

	@GetMapping("action1")
	public String action1(Model model) {
		model.addAttribute("message", "action1 with simple");
		return "multi";
	}

	@GetMapping("action2")
	public String action2(Model model) {
		model.addAttribute("message", "action2 with simple");
		return "multi";
	}

	@RequestMapping(value = "action2", params = "id")
	public String action2WithId(Model model) {
		model.addAttribute("message", "action2 with id");
		return "multi";
	}

	@GetMapping("**")
	public String actionWildCard(Model model) {
		model.addAttribute("message", "Action Wildcard");
		return "multi";
	}

	@GetMapping("{:\\d+}")
	public String actionWithDigit(Model model) {
		model.addAttribute("message", "Action with Digit");
		return "multi";
	}
}
