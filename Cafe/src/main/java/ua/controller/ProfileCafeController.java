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
import org.springframework.web.bind.support.SessionStatus;

import ua.model.request.CommentRequest;
import ua.service.CafeCommentService;
import ua.service.CafeIndexService;
import ua.service.CafeService;

@Controller
@RequestMapping("/profile/cafe/{cafeId}")
public class ProfileCafeController {

	private final CafeService service;
	private final CafeIndexService indexService;
	private final CafeCommentService commentService;
		
		@Autowired
		public ProfileCafeController(CafeService service,CafeIndexService indexService,CafeCommentService commentService) {
			this.service = service;
			this.indexService=indexService;
			this.commentService=commentService;
		}
	
	@GetMapping
	public String desc(@PathVariable Integer cafeId, Model model){
		model.addAttribute("cafe", service.findOneCafeView(cafeId));
		model.addAttribute("meals", indexService.findMealByCafeId(cafeId));
		model.addAttribute("cafeId", cafeId);
		return "profilecafe";
	}
	
}
