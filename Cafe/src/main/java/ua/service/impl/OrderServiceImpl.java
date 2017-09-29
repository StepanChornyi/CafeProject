package ua.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Order;
import ua.repository.OrderRepository;
import ua.service.OrderService;

@Service
public class OrderServiceImpl extends CrudServiceImpl<Order, Integer> implements OrderService {
//	private final OrderRepository repository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository repository) {
		super(repository);
//		this.repository=repository;
	}
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
