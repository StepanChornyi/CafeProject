package ua.service;

import java.security.Principal;
import java.time.LocalTime;
import java.util.List;

import ua.entity.Cafe;
import ua.entity.Comment;
import ua.entity.Type;
import ua.entity.User;
import ua.model.request.CafeRequest;
import ua.model.request.CommentRequest;
import ua.model.view.CafeView;

public interface CafeService {
	
	
	List<Type> findAllTypes();

	List<LocalTime> findAllOpenCloses();

	List<CafeView> findAllViews();

	void save(CafeRequest request,Principal principal);

	CafeRequest findOne(Integer id);
	
	Cafe findOneRequest(Integer id);

	void delete(Integer id);
	
	CafeRequest findOneDesc(Integer id);
	
	List<CafeView> findAllCafeByUserEmail(String email);
	
	User findOneUserByEmail(String email);
	
	List<Comment> findAllCommentByCafeId(Integer id);
	
	void saveComment(CommentRequest request);
	
	CafeView findOneCafeView(Integer id);
	
	Cafe findByName(String name);
}
