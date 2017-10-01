package ua.service.impl;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	    this.repository = repository;
	  }

	@Override
	public List<OrderView> findAllOrders(Integer id) {
		List<OrderView> orders = repository.findAllViews(id);
		for (OrderView order : orders) {
			order.setMeals(repository.findAllMealByOrderId(order.getId()));
		}
		return orders;
	}

	@Override
	public List<String> findMealsByCafeId(Integer id) {
		return repository.findMealsByCafeId(id);
	}

	@Override
	public List<Integer> findTableByCafeId(Integer id) {
		return repository.findTableByCafeId(id, false);
	}

	@Override
	public void saveNew(OrderRequest request) {
		request.setStatus(Status.EXECUTED.toString());
		double price = 0;
		for (Meal meal : request.getMeals()) {
			price += meal.getPrice().doubleValue();
		}
		request.setPrice(BigDecimal.valueOf(price));
		save(request);
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
	public void delete(Integer id) {
		repository.delete(id);
	}
	
	
	
	 
/*
	@Override
	public void save(OrderRequest request) {
		Order order=new Order();
		order.setId(request.getId());
		order.setMeals(request.getMeals());
		order.setTable(request.getTable());
		repository.save(order);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	@Override
	public OrderRequest findOne(Integer id) {
		Order order=repository.findOneRequest(id);
		OrderRequest request = new OrderRequest();
		request.setId(order.getId());
		request.setMeals(order.getMeals());
		request.setTable(order.getTable());
		return request;
	}
	
	

	@Override
	public List<OrderView> findAllViews() {
		return repository.findAllViews();
	}
	
	@Override
	public List<String> findAllMealByCafeId(Integer id) {
		return repository.findAllMealByCafeId(id);
	}
	
	
	
	 @Override
	@Transactional(readOnly=true)
	public List<OrderView> findAllOrdersByCafeId(Integer id) {
		List<OrderView> views = repository.findAllOrdersByCafeId(id);
		views.forEach(this::loadMeals);
		return views;
	}
	
	private void loadMeals(OrderView view) {
		view.setMeals(repository.findAllMealsByOrderId(view.getId()));
		//view.setIngredients(repository.findAllIngredientsByMealId(view.getId()));
	}



	@Override
	public Table findOneTable(Integer id) {
		return repository.findOneTable(id);
	}

	@Override
	public Order findOneOrderByTableId(Integer id) {
		return repository.findOneOrderByTableId(id);
	}

	*/

	

}