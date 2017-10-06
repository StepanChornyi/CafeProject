package ua.model.request;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import ua.entity.Cafe;

public class TableRequest {

	
	private Integer id;
	
	
	private Integer countOfPeople;
	
	
	private Integer tableNumber;
	
	
	private boolean isFree;
		
	@Pattern(regexp = "^([A-Z][a-z]+)?$", message = "Ім'я має починатись з великої літери")
	@NotBlank(message = "Це поле має бути заповнене")
	private String user;
	
	
	@Pattern(regexp = "^(\\+380[0-9]{9})?$", message = "Номер має бути у форматі +380XXXXXXXXX")
	@NotBlank(message = "Це поле має бути заповнене")
	private String userPhone;
	
	private Cafe cafe;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean getIsFree() {
		return isFree;
	}

	public void setIsFree(boolean isFree) {
		this.isFree = isFree;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	public Integer getCountOfPeople() {
		return countOfPeople;
	}

	public void setCountOfPeople(Integer countOfPeople) {
		this.countOfPeople = countOfPeople;
	}

	public Integer getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(Integer tableNumber) {
		this.tableNumber = tableNumber;
	}

	
}
