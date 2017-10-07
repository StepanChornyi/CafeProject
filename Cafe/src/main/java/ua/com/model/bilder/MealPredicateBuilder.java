package ua.com.model.bilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ua.entity.Cuisine;
import ua.entity.Ingredient;
import ua.entity.Meal;
import ua.model.filter.MealFilter;

public class MealPredicateBuilder {
	
	private final MealFilter filter;

	private final CriteriaBuilder criteriaBuilder;

	private final Root<Meal> root;

	private final List<Predicate> predicates = new ArrayList<>();
	
	public MealPredicateBuilder(MealFilter filter, CriteriaBuilder criteriaBuilder, Root<Meal> root) {
		this.filter = filter;
		this.criteriaBuilder = criteriaBuilder;
		this.root = root;
	}
	
	public Predicate toPredicate() {
		search();
		findByMinPrice();
		findByMaxPrice();
		findByCuisines();
		findByIngredients();
		return criteriaBuilder.and(predicates.stream().toArray(Predicate[]::new));
	}

	private void search() {
		if (!filter.getSearch().isEmpty()) {
			predicates.add(criteriaBuilder.like(root.get("title"), filter.getSearch() + "%"));
		}
	}
	
	private void findByMinPrice() {
		if (!filter.getMinPrice().isEmpty()) {
			predicates.add(criteriaBuilder.ge(root.get("price"), new BigDecimal(filter.getMinPrice().replace(',', '.'))));
		}
	}

	private void findByMaxPrice() {
		if (!filter.getMaxPrice().isEmpty()) {
			predicates.add(criteriaBuilder.le(root.get("price"), new BigDecimal(filter.getMaxPrice().replace(',', '.'))));
		}
	}
	
	private void findByCuisines() {
		if (!filter.getCuisinesIds().isEmpty()) {
			Join<Meal, Cuisine> join = root.join("cuisine");
			predicates.add(join.get("id").in(filter.getCuisinesIds()));
		}
	}
	
	private void findByIngredients() {
		if (!filter.getIngredientsIds().isEmpty()) {
			Join<Meal, Ingredient> join = root.join("ingredients");
			predicates.add(join.get("id").in(filter.getIngredientsIds()));
		}
	}
	
}