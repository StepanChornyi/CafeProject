package ua.service.impl;

import java.security.Principal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import ua.entity.Cafe;
import ua.entity.Type;
import ua.entity.User;
import ua.model.request.CafeRequest;
import ua.model.view.CafeView;
import ua.repository.CafeRepository;
import ua.service.CafeService;

@Service
public class CafeServiceImpl   implements CafeService {

	private final CafeRepository repository;


	
	
	public CafeServiceImpl(CafeRepository repository) {
		this.repository = repository;
	}


	@Override
	public List<LocalTime> findAllOpenCloses() {
		return repository.findAllOpenClose();
	}


	@Override
	public List<CafeView> findAllViews() {
		return repository.findAllViews();
	}


	@Override
	public void save(CafeRequest request,Principal principal) {
		Cafe cafe=new Cafe();
		cafe.setName(request.getName());
		cafe.setId(request.getId());
		cafe.setRate(request.getRate());
		cafe.setCountRate(request.getCountRate());
		cafe.setShortDescription(request.getShortDescription());
		cafe.setPhotoUrl(request.getPhotoUrl());
		cafe.setAddress(request.getAddress());
		cafe.setVersion(request.getVersion());
		cafe.setFullDescription(request.getFullDescription());
		cafe.setType(Type.valueOf(request.getType()));
		if(request.getPhone().length()<14)
		cafe.setPhone(request.getPhone());
		cafe.setOpen(request.getOpen());
		cafe.setClose(request.getClose());
		cafe.setUser(repository.findOneUserByEmail(principal.getName()));
		repository.save(cafe);
	}


	@Override
	public List<Type> findAllTypes() {
		List<Type> types=new ArrayList<>();
		for(int i=0;i<Type.values().length;i++){
			types.add(Type.values()[i]);
		}
		return types;
	}



	@Override
	public CafeRequest findOne(Integer id) {
		Cafe cafe=repository.findOne(id);
		CafeRequest request = new CafeRequest();
		request.setName(cafe.getName());
		request.setId(cafe.getId());
		request.setRate(cafe.getRate());
		request.setCountRate(cafe.getCountRate());
		request.setPhotoUrl(cafe.getPhotoUrl());
		request.setAddress(cafe.getAddress());
		request.setVersion(cafe.getVersion());
		request.setFullDescription(cafe.getFullDescription());
		request.setShortDescription(cafe.getShortDescription());
		request.setType(String.valueOf(cafe.getType()));
		request.setPhone(cafe.getPhone());
		request.setOpen(cafe.getOpen());
		request.setClose(cafe.getClose());
		return request;
	}


	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}


	@Override
	public CafeRequest findOneDesc(Integer id) {
		Cafe cafe=repository.findOneDesc(id);
		CafeRequest request = new CafeRequest();
		request.setName(cafe.getName());
		request.setId(cafe.getId());
		request.setRate(cafe.getRate());
		request.setCountRate(cafe.getCountRate());
		request.setPhotoUrl(cafe.getPhotoUrl());
		request.setAddress(cafe.getAddress());
		request.setVersion(cafe.getVersion());
		request.setFullDescription(cafe.getFullDescription());
		request.setShortDescription(cafe.getShortDescription());
		request.setType(String.valueOf(cafe.getType()));
		request.setPhone(cafe.getPhone());
		request.setOpen(cafe.getOpen());
		request.setClose(cafe.getClose());
		return request;
	}


	@Override
	public List<CafeView> findAllCafeByUserEmail(String email) {
		return repository.findAllCafeByUserEmail(email);
	}


	@Override
	public User findOneUserByEmail(String email) {
		return repository.findOneUserByEmail(email);
	}


	@Override
	public Cafe findOneRequest(Integer id) {
		return repository.findOneRequest(id);
	}


	
}



	
