package ua.service;



import java.util.List;

import ua.entity.Order;
import ua.entity.Table;
import ua.model.request.OrderRequest;
import ua.model.view.OrderView;

public interface OrderService {

	
	void saveNew(OrderRequest request);
	
	void save(OrderRequest request);
	
	List<Integer> findTableByCafeId(Integer id);
	
	List<OrderView> findAllOrders(Integer id);
	
	List<String> findMealsByCafeId(Integer id);
	
	void delete(Integer id);
	
	void setDone(Integer id);
	
	void setPaid(Integer id);
}