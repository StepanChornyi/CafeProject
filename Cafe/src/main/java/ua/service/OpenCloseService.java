package ua.service;

import java.util.List;

import ua.entity.OpenClose;
import ua.model.request.OpenCloseRequest;

public interface OpenCloseService{
	
	OpenCloseRequest findOneRequest(Integer id);
	
	void saveRequest(OpenCloseRequest request);
	
	List<OpenClose> findAll();

}
