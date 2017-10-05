package ua.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment extends AbstractEntity{
	
	@Lob
	private String comment;
	
	private String user;
	
	private BigDecimal rate;
	
	@ManyToOne
	private Comment parent;
	
	@OneToMany(mappedBy="parent")
	private List<Comment> comments = new ArrayList<>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Cafe cafe;
	
	public Comment() {
		super();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Comment getParent() {
		return parent;
	}

	public void setParent(Comment parent) {
		this.parent = parent;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
