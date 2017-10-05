package ua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import ua.model.request.CommentRequest;
import ua.service.CafeService;

@Controller
@RequestMapping("/cafe/{cafeId}/comments")
public class CommentController {
	private final CafeService service;

	public CommentController(CafeService service) {
		this.service = service;
	}
	
	
	
}
