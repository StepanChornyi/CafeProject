package ua.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.entity.OpenClose;
import ua.model.request.OpenCloseRequest;
import ua.service.OpenCloseService;

@Controller
@RequestMapping("/admin/time")
@SessionAttributes("time")
public class AdminOpenCloseController {
	
private final OpenCloseService service;
	
	@Autowired
	public AdminOpenCloseController(OpenCloseService service) {
		this.service=service;
	}
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("times",service.findAll());
		return "time";
	}
	
	@ModelAttribute("time")
	public OpenClose getForm(){
		return new OpenClose();
	}
	
	
	@GetMapping("cancel")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/time";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id,Model model){
		model.addAttribute("time",service.findOneRequest(id));
		return show(model);
	}
	
	@PostMapping
	public String save(@ModelAttribute("time") @Valid OpenCloseRequest request, BindingResult br, SessionStatus status, Model model) {
		if(br.hasErrors())return show(model);
		service.saveRequest(request);
		return cancel(status);
	}
}
