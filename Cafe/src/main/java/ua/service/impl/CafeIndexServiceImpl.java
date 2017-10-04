package ua.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import ua.entity.Meal;
import ua.model.view.CafeIndexView;
import ua.repository.CafeIndexRepository;
import ua.service.CafeIndexService;

@Service
public class CafeIndexServiceImpl implements CafeIndexService {

	private CafeIndexRepository repository;

	public CafeIndexServiceImpl(CafeIndexRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<CafeIndexView> findTopFiveCafe() {
		 List<CafeIndexView> cafeIndexViews= repository.findAllCafes();
		    List<CafeIndexView> cafeTopFive = new ArrayList<>();
		    Iterator<CafeIndexView> iter = cafeIndexViews.iterator();
		    int i=0;
		    while(iter.hasNext()&&i<5){
			      CafeIndexView cafe = iter.next();
			      cafeTopFive.add(cafe);  
			      i++;
		    }
		
		return cafeTopFive;
	}

	@Override
	public List<Meal> findMealByCafeId(Integer id) {
		return repository.findMealByCafeId(id);
	}

	@Override
	public List<CafeIndexView> findAllCafeView() {
		return repository.findAllCafes();
	}
	
	
	
}
