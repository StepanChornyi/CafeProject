package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import ua.validation.annotation.UniqueCuisine;
import ua.validation.annotation.UniqueIngredient;

@Entity
@Table(name = "ingredient")
public class Ingredient extends AbstractEntity {

	@UniqueIngredient(message="Такий інградієнт вже існує в БД")
	@NotBlank(message="Це поле має бути заповненим")
	@Pattern(regexp = "^[A-Z][a-zA-Z0-9]+| *$", message="Назва має починатись з великої букви")
	private String name;
	
	public Ingredient() {
	}

	public Ingredient(String name) {
		this.name = name;
	}

	@ManyToMany(mappedBy = "ingredients")
	private List<Meal> meals = new ArrayList<>();

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
