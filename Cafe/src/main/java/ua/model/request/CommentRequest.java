package ua.model.request;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import ua.entity.Cafe;


public class CommentRequest {

	private Integer id;

	
	
	@Pattern(regexp = "^([A-Z][a-z]+)?$", message = "Ім'я має починатись з великої літери")
	@NotBlank(message = "Це поле має бути заповнене")
	private String user;
	
	@NotBlank(message = "Це поле має бути заповнене")
	private String comment;
	
	@Pattern(regexp = "^([0-9]+([,.][0-9]{1,2})?)?$", message = "this value is not valid")
	@Max(value = 5, message = "must be less than 5")
	@Min(value = 1, message = "must be greater than 1")
	@NotBlank(message = "this field is required")
	private String rate;
	
	private Integer cafeId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public BigDecimal getRate() {
		if(rate!=null)
		return BigDecimal.valueOf(Integer.valueOf(rate).intValue());
		return null;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate.toString();
	}

	public Integer getCafeId() {
		return cafeId;
	}

	public void setCafeId(Integer cafeId) {
		this.cafeId = cafeId;
	}



	
}
