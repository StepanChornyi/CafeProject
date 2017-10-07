package ua.service.impl;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.OpenClose;
import ua.model.request.OpenCloseRequest;
import ua.repository.OpenCloseRepository;
import ua.service.OpenCloseService;
@Service
public class OpenCloseServiceImpl implements OpenCloseService{

	private final OpenCloseRepository repository;
	
	@Autowired
	public OpenCloseServiceImpl(OpenCloseRepository repository) {
		this.repository = repository;
	}

	@Override
	public OpenCloseRequest findOneRequest(Integer id) {
		OpenClose time = repository.findOne(id);
		OpenCloseRequest request = new OpenCloseRequest();
		request.setId(time.getId());
		request.setTime(time.getTime().toString());
		return request;
	}

	@Override
	public void saveRequest(OpenCloseRequest request) {
		OpenClose time = new OpenClose();
		time.setId(request.getId());
		//time.setTime(LocalTime.of(Integer.valueOf(request.getTime().split(":")[0]),Integer.valueOf(request.getTime().split(":")[1])));
		//repository.save(time);
	}

	@Override
	public List<OpenClose> findAll() {
		return repository.findAll();
	}
	
	

}
