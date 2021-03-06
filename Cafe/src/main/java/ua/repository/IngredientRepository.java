package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{
	boolean existsByName(String name);
	
	Ingredient findByName(String name);
}
