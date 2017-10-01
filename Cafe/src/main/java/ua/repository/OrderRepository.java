package ua.repository;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Order;
import ua.entity.Table;
import ua.model.view.OrderView;
import ua.model.view.TableView;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	@Query("SELECT new ua.model.view.OrderView(o.id, t.tableNumber, o.status, o.price) FROM Order o JOIN o.table t WHERE t.cafe.id=?1")
	List<OrderView> findAllViews(Integer id);
	
	@Query("SELECT m.title FROM Meal m  JOIN m.orders o WHERE o.id=?1")
	List<String> findAllMealByOrderId(Integer id);
	
	@Query("SELECT m.title FROM Meal m  JOIN m.cafe c WHERE c.id=?1")
	List<String> findMealsByCafeId(Integer id);
	
	@Query("SELECT t.id FROM Table t JOIN t.cafe c WHERE c.id=?1 AND t.isFree=?2")
	List<Integer> findTableByCafeId(Integer id, boolean free);
	
/*
	@Query("SELECT m.title FROM Meal m  WHERE m.cafe.id=?1")
	List<String> findAllMealByCafeId(Integer id);
		
	@Query("SELECT DISTINCT o FROM Order o JOIN FETCH o.table LEFT JOIN FETCH o.meals WHERE o.id=?1")
	Order findOneRequest(Integer id);
	
	@Query("SELECT m.title FROM Meal m JOIN m.orders o WHERE o.id=?1")
	List<String> findAllMealsByOrderId(Integer id);
	
	@Query("SELECT new ua.model.view.OrderView(o.id, t.countOfPeople) FROM Order o JOIN o.table t WHERE t.cafe.id=?1")
	List<OrderView> findAllOrdersByCafeId(Integer id);
	
	@Query("SELECT t FROM Table t WHERE t.id=?1")
	 Table findOneTable(Integer id);
	
	@Query("SELECT o FROM Order o WHERE o.table.id=?1")
	Order findOneOrderByTableId(Integer id);
	
	*/
}