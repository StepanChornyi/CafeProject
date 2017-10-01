package ua.model.request;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ua.entity.Meal;
import ua.entity.Table;

public class OrderRequest {
	
	private Integer id;
	
	private String status;
	
	private BigDecimal price;
	
	private Table table;
	
	private List<String> meals = new ArrayList<>();

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

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
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
