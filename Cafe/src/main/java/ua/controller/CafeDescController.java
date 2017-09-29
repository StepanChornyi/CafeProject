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

import ua.model.request.CafeCommentRequest;
import ua.service.CafeCommentService;
import ua.service.CafeIndexService;
import ua.service.CafeService;

@Controller
@RequestMapping("/cafedesc")
@SessionAttributes("comment")
public class CafeDescController {

private final CafeService service;
private final CafeIndexService indexService;
private final CafeCommentService commentService;
	
	@Autowired
	public CafeDescController(CafeService service,CafeIndexService indexService,CafeCommentService commentService) {
		this.service = service;
		this.indexService=indexService;
		this.commentService=commentService;
	}
	
	@GetMapping("/{id}")
	public String desc(@PathVariable Integer id, Model model){
		model.addAttribute("cafe", service.findOne(id));
		model.addAttribute("meals", indexService.findMealByCafeId(id));
		model.addAttribute("comments", commentService.findAllCommentByCafeId(id));
		return "cafedesc";
	}
	
	@PostMapping("/{id}")
	public String saveComment(@ModelAttribute("comment") CafeCommentRequest commentRequest,@PathVariable Integer id, SessionStatus status) {
		commentService.saveComment(commentRequest, id);
		return cancel(status);
	}
	
	@ModelAttribute("comment")
	public CafeCommentRequest getFormComment() {
		return new CafeCommentRequest();
	}
	
	@GetMapping("/{id}/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/cafedesc/{id}";
	}	
	
	
}
