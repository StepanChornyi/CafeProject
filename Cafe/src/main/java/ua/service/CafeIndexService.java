package ua.service;

import java.util.List;

import ua.entity.Meal;
import ua.model.view.CafeIndexView;

public interface CafeIndexService {
	
	List<CafeIndexView> findTopFiveCafe();
	
	List<CafeIndexView> findAllCafeView();
	
	List<Meal> findMealByCafeId(Integer id);
}
