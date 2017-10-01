package ua.service;



import java.util.List;

import ua.entity.Order;
import ua.entity.Table;
import ua.model.request.OrderRequest;
import ua.model.view.OrderView;

public interface OrderService {
/*
	List<String> findAllMealByCafeId(Integer id);
	
	List<OrderView> findAllViews();
	
	void save(OrderRequest request);
	
	  
	  void delete(Integer id);
	  
	  OrderRequest findOne(Integer id);
	  
	  List<OrderView> findAllOrdersByCafeId(Integer id);
	  
	  Table findOneTable(Integer id);
	  
	  Order findOneOrderByTableId(Integer id);
	*/
	
	List<Integer> findTableByCafeId(Integer id);
	
	List<OrderView> findAllOrders(Integer id);
	
	List<String> findMealsByCafeId(Integer id);
}