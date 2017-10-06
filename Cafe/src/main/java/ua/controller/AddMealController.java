package ua.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.model.request.MealRequest;
import ua.service.MealService;

@Controller
@RequestMapping("/addmeal")
@SessionAttributes("addmeal")
public class AddMealController {

private final MealService service;
	
	@Autowired
	public AddMealController(MealService service) {
		this.service = service;
	}
	
	@ModelAttribute("addmeal")
	public MealRequest getForm() {
		return new MealRequest();
	}
	
	@PostMapping
	public String save(@ModelAttribute("addmeal") MealRequest request, SessionStatus status) {
		service.save(request);
		return cancel(status);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model,Principal principal) {
		model.addAttribute("addmeal", service.findOne(id));
		return show(model,principal);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/profile/meal";
	}
	
	@GetMapping
	public String show(Model model,Principal principal) {
		model.addAttribute("ingredients", service.findAllIngredients());
		model.addAttribute("cuisines", service.findAllCuisines());
		model.addAttribute("cafes", service.findAllCafeByUserEmail(principal.getName()));
		return "addmeal";
	}
}
