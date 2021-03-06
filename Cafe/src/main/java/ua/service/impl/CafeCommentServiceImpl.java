package ua.service.impl;



import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Comment;
import ua.model.request.CommentRequest;
import ua.model.view.CafeCommentView;
import ua.repository.CafeCommentRepository;
import ua.repository.CafeRepository;
import ua.service.CafeCommentService;

@Service
public class CafeCommentServiceImpl  implements CafeCommentService{

	private final CafeCommentRepository repository;
	
	private final CafeRepository cafeRepository;
	

	@Autowired
	public CafeCommentServiceImpl(CafeCommentRepository repository,CafeRepository cafeRepository) {
		this.repository = repository;
		this.cafeRepository=cafeRepository;
	}

	

	

}
