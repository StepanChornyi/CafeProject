package ua.service;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.model.request.MealRequest;
import ua.model.view.MealView;

public interface MealService {

	List<String> findAllCuisines();

	List<String> findAllIngredients();

	List<MealView> findAllMealByCafeId(Principal principal);

	void save(MealRequest request);

	MealRequest findOne(Integer id);

	void delete(Integer id);
	
	List<String> findAllCafeByUserEmail(String email);
	
	Page<MealView> findAllMeals(Pageable pageable);
		
}
