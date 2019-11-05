package com.botscrewcorporation.springboot.application.service.lectorservice;

import java.util.List;

import com.botscrewcorporation.springboot.application.entity.Lector;

public interface LectorService {
	
	List<Integer> getDepartmentStatistic(int departmentId);
	
	public List<Lector> globalSearch(String str);

}
