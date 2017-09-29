package ua.service;

import java.util.List;

import ua.model.request.CafeCommentRequest;
import ua.model.view.CafeCommentView;

public interface CafeCommentService{


	List<CafeCommentView> findAllCommentByCafeId(Integer id);

	void saveComment(CafeCommentRequest commentRequest, Integer id);
	
	
	
}
