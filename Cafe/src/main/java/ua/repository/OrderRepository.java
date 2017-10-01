package ua.repository;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Meal;
import ua.entity.Order;
import ua.entity.Table;
import ua.model.view.OrderView;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	@Query("SELECT m FROM Meal m JOIN m.cafe c WHERE c.id=?1")
	List<Meal> findAllMealsByCafeId(Integer id);
	
	@Query("SELECT t FROM Table t JOIN t.cafe c WHERE c.id=?1 AND t.isFree=?2")
	List<Table> findAllFreeTablesByCafeId(Integer id, boolean isFree);
	
	//@Query("SELECT new ua.model.view.OrderView(o.id, o.status, t.tableNumber, o.price) FROM Oreder o JOIN o.table t WHERE t.id=?1")
	//List<OrderView> findAllOrdersByCafeId(Integer id);
	
	
	
}
