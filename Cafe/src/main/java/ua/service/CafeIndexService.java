package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Meal;
import ua.model.view.CafeIndexView;

public interface CafeIndexService {
	
	List<CafeIndexView> findTopFiveCafe();
	
	Page<CafeIndexView> findAllCafeView(Pageable pageable);
	
	List<Meal> findMealByCafeId(Integer id);
}
