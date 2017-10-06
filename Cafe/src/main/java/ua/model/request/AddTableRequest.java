package ua.model.request;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class AddTableRequest {
	
	Integer id;
	
	//@NotBlank(message="Це поле має бути заповненим")
	//@Pattern(regexp = "^([1-9][0-9])?$", message="Кількість місць має бути 1-99")
	Integer countOfPeople;
	
	//@NotBlank(message="Це поле має бути заповненим")
	//@Pattern(regexp = "^([1-Z][a-z])?$", message="Номер столика має бути 1-99")
	Integer tableNumber;
	
	

	public AddTableRequest() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCountOfPeople() {
		return countOfPeople;
	}

	public void setCountOfPeople(Integer countOfPeople) {
		this.countOfPeople = countOfPeople;
	}

	public Integer getNumber() {
		return tableNumber;
	}

	public void setNumber(Integer tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	

}
