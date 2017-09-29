package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Cafe;
import ua.entity.Table;
import ua.model.view.TableView;

public interface TableRepository extends JpaRepository<Table,Integer> {
  
  @Query("SELECT c.name FROM Cafe c WHERE c.user.email=?1")
  List<String> findAllCafe(String email);
  
  @Query("SELECT c FROM Cafe c WHERE c.id=?1")
  Cafe findCafeById(Integer id);
  
  @Query("SELECT new ua.model.view.TableView(t.id, t.countOfPeople, t.isFree, t.user, t.userPhone, c.name) FROM Table t JOIN t.cafe c WHERE c.id=?1")
  List<TableView> findTableViewsByCafeId(Integer id);

}