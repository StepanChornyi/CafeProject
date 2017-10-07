package ua.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import ua.model.filter.CafeFilter;
import ua.model.filter.MealFilter;
import ua.repository.CafeViewRepository;
import ua.repository.MealViewRepository;
import ua.service.CafeIndexService;
import ua.service.CafeService;
import ua.service.CuisineService;
import ua.service.IngredientService;
import ua.service.MealService;

@Controller
public class MainController {

private final CafeIndexService service;
private final CafeService cafeService;
private final MealService mealService;

private final CafeViewRepository repository;

//private final CafeService cafeService;

private final MealViewRepository mealRep;


private final CuisineService cuisineService;

private final IngredientService servicee;
	
	@Autowired
	public MainController(MealViewRepository mealRep,CafeViewRepository repository,IngredientService servicee,CuisineService cuisineService, CafeIndexService service, MealService mealService, CafeService cafeService) {
		this.repository = repository;
		this.mealRep = mealRep;
		this.servicee = servicee;
		this.cuisineService = cuisineService;
		this.service = service;
		this.mealService = mealService;
		this.cafeService = cafeService;
	}
	
	@ModelAttribute("cafeFilter")
	public CafeFilter getFilter(){
		return new CafeFilter();
	}
	
	@ModelAttribute("mealFilter")
	public MealFilter getFilterMeal(){
		return new MealFilter();
	}
	
	@GetMapping("/all/allcafe")
	public String showAllCafe(Model model , @ModelAttribute("cafeFilter") CafeFilter filter, @PageableDefault Pageable pageable){
		model.addAttribute("cafes",repository.findAll(filter, pageable));
		return "cafe";
	}
	
	@GetMapping("/all/allmeal")
	public String showAllMeal(Model model,@ModelAttribute("mealFilter") MealFilter filter, @PageableDefault Pageable pageable) {
		model.addAttribute("meals", mealRep.findAll(filter, pageable));
		model.addAttribute("cuisines", cuisineService.findAll());
		model.addAttribute("ingredients", servicee.findAll());
		return "allmeals";
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
	public String showAllMeals(Model model,@ModelAttribute("mealFilter") MealFilter filter, @PageableDefault Pageable pageable) {
		model.addAttribute("meals", mealRep.findAll(filter, pageable));
		model.addAttribute("cuisines", cuisineService.findAll());
		model.addAttribute("ingredients", servicee.findAll());
		return "allmeals";
	}
	
	@GetMapping("/meal/{cafe}")
	public String mealc(Model model, @PathVariable String cafe) {
		return "redirect:/cafedesc/"+cafeService.findByName(cafe).getId();
	}
}
