package ua.service;

import java.util.List;

import ua.entity.Meal;
import ua.entity.Order;
import ua.entity.Table;
import ua.model.request.OrderRequest;
import ua.model.view.OrderView;

public interface OrderService{

	
	List<Meal> findAllMealsByCafeId(Integer id);
	
	List<Table> findAllFreeTablesByCafeId(Integer id);
	
	void save(OrderRequest request);
	
	void saveNew(OrderRequest request);
	
	//OrderView findAllOrdersByCafeId(Integer id);
	
}
