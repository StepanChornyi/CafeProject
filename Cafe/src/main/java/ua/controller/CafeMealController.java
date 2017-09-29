package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.service.CafeIndexService;

@Controller
@RequestMapping("/")
@SessionAttributes("cafemeal")
public class CafeMealController {

	
private final CafeIndexService service;
	
	@Autowired
	public CafeMealController(CafeIndexService service) {
		this.service = service;
	}
	
	@GetMapping("/cafemeal/{id}")
	public String getMeal(@PathVariable Integer id, Model model){
		model.addAttribute("meals", service.findMealByCafeId(id));
		return "cafemeal";
	}
}
