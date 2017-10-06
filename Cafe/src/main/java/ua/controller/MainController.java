package ua.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ua.service.CafeIndexService;
import ua.service.CafeService;
import ua.service.MealService;

@Controller
public class MainController {

private final CafeIndexService service;
private final CafeService cafeService;
private final MealService mealService;
	
	@Autowired
	public MainController(CafeIndexService service, MealService mealService, CafeService cafeService) {
		this.service = service;
		this.mealService = mealService;
		this.cafeService = cafeService;
	}
	
	@GetMapping("/")
	public String index(Model model, Principal principal) {
		/*if(user!=null) {
			model.addAttribute("message", "Hello "+user.getEmail());
			System.out.println(user.getRole());
			System.out.println(user.getPassword());
		} else {
			model.addAttribute("message", "Hello unregistered user");
		}*/
		if(principal!=null){
		model.addAttribute("message", "Hello "+principal.getName());
		}else{
			model.addAttribute("message", "Hello unregister user");
		}
		model.addAttribute("cafes", service.findTopFiveCafe());
		return "index";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/cafe")
	public String cafe(Model model, @PageableDefault Pageable pageable) {
		model.addAttribute("cafes", service.findAllCafeView(pageable));
		return "cafe";
	}
	
	@GetMapping("/meal")
	public String meal(Model model, @PageableDefault Pageable pageable) {
		model.addAttribute("meals", mealService.findAllMeals(pageable));
		return "allmeals";
	}
	
	@GetMapping("/meal/{cafe}")
	public String mealc(Model model, @PathVariable String cafe) {
		return "redirect:/cafedesc/"+cafeService.findByName(cafe).getId();
	}
}
