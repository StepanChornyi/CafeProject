package ua.repository;


import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.OpenClose;

public interface OpenCloseRepository extends JpaRepository<OpenClose, Integer>{

//	@Query("FROM Cafe WHERE name=?1")
//	Cafe findByName(String name);
	
	@Query("SELECT DISTINCT oc FROM OpenClose oc WHERE oc.time=?1")
	OpenClose findByTime(LocalTime time);
	
	@Query("SELECT time FROM OpenClose time WHERE time.time=?1")
	OpenClose findOneByTime(LocalTime time);
	
	@Query("SELECT time FROM OpenClose time WHERE time.id=?1")
	OpenClose findOneById(Integer id);
}
