package ua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Cafe;
import ua.entity.Table;
import ua.model.request.TableRequest;
import ua.model.view.TableView;
import ua.repository.TableRepository;
import ua.service.TableService;

@Service
public class TableServiceImpl implements TableService {

	private final TableRepository repository;

	@Autowired
	public TableServiceImpl(TableRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<String> findAllCafes(String email) {
		return repository.findAllCafe(email);
	}

	@Override
	public List<TableView> findTableViewsByCafeId(Integer id) {
		return repository.findTableViewsByCafeId(id);
	}

	@Override
	public Cafe findOneCafeById(Integer id) {
		return repository.findCafeById(id);
	}

	@Override
	public void save(TableRequest request) {
		request.setIsFree(true);
		saveRequest(request);
	}

	@Override
	public void saveNew(TableRequest request, Integer id) {
		request.setCafe(repository.findCafeById(id));
		request.setIsFree(true);
		saveRequest(request);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	@Override
	public TableRequest findOne(Integer id) {
		Table table = repository.findOne(id);
		TableRequest request = new TableRequest();
		request.setId(table.getId());
		request.setCountOfPeople(Integer.valueOf(table.getCountOfPeople()));
		request.setTableNumber(Integer.valueOf(table.getTableNumber()));
		request.setUser(table.getUser());
		request.setUserPhone(table.getUserPhone());
		request.setIsFree(table.getIsFree());
		request.setCafe(table.getCafe());
		return request;
	}

	@Override
	public void reserve(TableRequest request) {
		request.setIsFree(false);
		saveRequest(request);
	}

	@Override
	public void dereserve(Integer id) {
		Table table = repository.findOne(id);
		table.setUser(null);
		table.setUserPhone(null);
		table.setIsFree(true);
		repository.save(table);
	}

	@Override
	public void saveRequest(TableRequest request) {
		Table table = new Table();
		table.setId(request.getId());
		table.setCountOfPeople(request.getCountOfPeople().intValue());
		table.setTableNumber(request.getTableNumber().intValue());
		table.setUser(request.getUser());
		table.setUserPhone(request.getUserPhone());
		table.setIsFree(request.getIsFree());
		table.setCafe(request.getCafe());
		repository.save(table);
	}

	@Override
	public List<TableView> findFreeTableViewsByCafeId(Integer id) {
		return repository.findFreeTableViewsByCafeId(id, true);
	}
	
	

}