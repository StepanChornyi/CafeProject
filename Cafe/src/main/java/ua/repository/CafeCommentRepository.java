package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.CafeComment;
import ua.model.view.CafeCommentView;

public interface CafeCommentRepository extends JpaRepository<CafeComment, Integer> {

	@Query("SELECT new ua.model.view.CafeCommentView(comment.comment,  comment.user, comment.time) FROM CafeComment comment JOIN comment.cafe cafe WHERE cafe.id=?1")
	List<CafeCommentView> findAllCommentByCafeId(Integer id);
	
}
//JOIN comment.cafe cafe