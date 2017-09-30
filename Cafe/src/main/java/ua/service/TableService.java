package ua.service;

import java.util.List;

import ua.entity.Cafe;
import ua.model.request.TableRequest;
import ua.model.view.TableView;

public interface TableService{

  List<String> findAllCafes(String email);
  
  Cafe findOneCafeById(Integer id);
  
  List<TableView> findTableViewsByCafeId(Integer id);
  
  void saveRequest(TableRequest request);
  
  void save(TableRequest request);
  
  void saveNew(TableRequest request, Integer id);
  
  void delete(Integer id);
  
  TableRequest findOne(Integer id);
  
  void reserve(TableRequest request);
  
  void dereserve(Integer id);
  
}
