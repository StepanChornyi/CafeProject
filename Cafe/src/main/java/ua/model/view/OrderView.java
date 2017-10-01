package ua.model.view;

import java.math.BigDecimal;
import java.util.List;

public class OrderView {
	
	private Integer id;
	
	private String status;
	
	private Integer table;
	
	private BigDecimal price;
	
	private List<String> meals;
	
	

	public OrderView(Integer id, String status, Integer table, BigDecimal price) {
		super();
		this.id = id;
		this.status = status;
		this.table = table;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTable() {
		return table;
	}

	public void setTable(int table) {
		this.table = table;
	}

	public List<String> getMeals() {
		return meals;
	}

	public void setMeals(List<String> meals) {
		this.meals = meals;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	
	
	
}
