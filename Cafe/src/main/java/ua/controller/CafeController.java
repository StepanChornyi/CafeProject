package ua.controller;


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

import ua.model.request.CommentRequest;
import ua.service.CafeCommentService;
import ua.service.CafeIndexService;
import ua.service.CafeService;

@Controller
@RequestMapping("/cafedesc")
@SessionAttributes("comment")
public class CafeController {

private final CafeService service;
private final CafeIndexService indexService;
private final CafeCommentService commentService;
	
	@Autowired
	public CafeController(CafeService service,CafeIndexService indexService,CafeCommentService commentService) {
		this.service = service;
		this.indexService=indexService;
		this.commentService=commentService;
	}
	
	@GetMapping("/{id}")
	public String desc(@PathVariable Integer id, Model model){
		model.addAttribute("cafe", service.findOneCafeView(id));
		model.addAttribute("meals", indexService.findMealByCafeId(id));
		model.addAttribute("comments", service.findAllCommentByCafeId(id));
		model.addAttribute("cafeId", id);
		return "cafedesc";
	}
	
	
	@GetMapping("/{id}/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/cafedesc/{id}";
	}	
	
	
	@PostMapping("/{id}/comment")
	public String save(Model model, @PathVariable Integer id, @ModelAttribute("comment") CommentRequest request,SessionStatus status) {
		request.setCafeId(id);
		service.saveComment(request);
		return cancel(status);
	}
	
	
	
	@ModelAttribute("comment")
	public CommentRequest getFormComment() {
		return new CommentRequest();
	}
	
	
	
}
