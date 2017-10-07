package ua.model.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class AddTableRequest {
	
	Integer id;
	
	@Max(value = 100, message = "must be less than 100")
	  @Min(value = 1, message = "must be greater than 0")
	  @Pattern(regexp = "^([0-9]+([,.][0-9]{1,2})?)?$", message = "this value is not valid")
	  @NotBlank(message = "this field is required")
	String countOfPeople;
	
	@Max(value = 100, message = "must be less than 100")
	  @Min(value = 1, message = "must be greater than 0")
	  @Pattern(regexp = "^([0-9]+([,.][0-9]{1,2})?)?$", message = "this value is not valid")
	  @NotBlank(message = "this field is required")
	String tableNumber;
	
	

	public AddTableRequest() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountOfPeople() {
		return countOfPeople;
	}

	public void setCountOfPeople(String countOfPeople) {
		this.countOfPeople = countOfPeople;
	}

	public String getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}

	
	

}
