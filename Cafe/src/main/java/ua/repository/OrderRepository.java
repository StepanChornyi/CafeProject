package ua.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
//	
//	@Query("SELECT i.title FROM Meal i JOIN i.cafe m WHERE m.id=?1")
//	List<String> findAllMealsByCafeId(Integer id);
//	
//	@Query("SELECT t.countOfPeople FROM Table t JOIN t.cafe c WHERE c.id=?1")
//	List<String> findAlltablesByCafeId(Integer id);
//	
//	
	
}
