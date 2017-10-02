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

import ua.model.request.CafeRequest;
import ua.service.CafeService;

@Controller
@RequestMapping("/profile/addcafe")
@SessionAttributes("addcafe")
public class AddCafeController {

	
private final CafeService service;
	
	@Autowired
	public AddCafeController(CafeService service) {
		this.service = service;
	}
	
	@ModelAttribute("addcafe")
	public CafeRequest getForm() {
		return new CafeRequest();
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/profile";
	}
	
	@PostMapping
	public String save(@ModelAttribute("addcafe") CafeRequest request, SessionStatus status,Principal principal) {
		service.save(request,principal);
		return cancel(status);
	}
	
	@GetMapping
	public String showFrom(Model model) {
		model.addAttribute("times", service.findAllOpenCloses());
		model.addAttribute("types",service.findAllTypes());
		return "addcafe";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("addcafe", service.findOne(id));
		return showFrom(model);
	}
	
}
