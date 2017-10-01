package ua.service.impl;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Meal;
import ua.entity.Order;
import ua.entity.Status;
import ua.entity.Table;
import ua.model.request.OrderRequest;
import ua.model.view.OrderView;
import ua.repository.OrderRepository;
import ua.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository repository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository repository) {
		this.repository=repository;
	}

	@Override
	public List<Meal> findAllMealsByCafeId(Integer id) {
		return repository.findAllMealsByCafeId(id);
	}

	@Override
	public List<Table> findAllFreeTablesByCafeId(Integer id) {
		return repository.findAllFreeTablesByCafeId(id, false);
	}
	
	@Override
	public void save(OrderRequest request) {
		Order order = new Order();
		order.setId(request.getId());
		order.setMeals(request.getMeals());
		order.setPrice(request.getPrice());
		order.setStatus(Status.valueOf(request.getStatus()));
		order.setTable(request.getTable());
		repository.save(order);
	}

	@Override
	public void saveNew(OrderRequest request) {
		BigDecimal price = new BigDecimal(0);
		for (Meal meal : request.getMeals()) {
			price.add(meal.getPrice());
		}
		request.setPrice(price);
		request.setStatus(Status.GETED.toString());;
		save(request);
	}
/*
	@Override
	public OrderView findAllOrdersByCafeId(Integer id) {
		return null;//repository.findAllOrdersByCafeId(id);
	}
	*/

	
	
	
//
//	@Override
//	public List<String> findAllCafes() {
//		return repository.findAllCafes();
//	}
//
//	@Override
//	public List<String> findAllMealsByCafeId(Integer id) {
//		return repository.findAllMealsByCafeId(id);
//	}
//
//	@Override
//	public List<String> findAlltablesByCafeId(Integer id) {
//		return repository.findAlltablesByCafeId(id);
//	}

	

}
