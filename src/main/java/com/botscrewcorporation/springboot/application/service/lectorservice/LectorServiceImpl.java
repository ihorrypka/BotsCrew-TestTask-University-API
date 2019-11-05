package com.botscrewcorporation.springboot.application.service.lectorservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.botscrewcorporation.springboot.application.entity.Degree;
import com.botscrewcorporation.springboot.application.entity.Lector;
import com.botscrewcorporation.springboot.application.repository.DegreeRepository;
import com.botscrewcorporation.springboot.application.repository.LectorRepository;

@Service
public class LectorServiceImpl implements LectorService {

	private LectorRepository lectorRepository;
	private DegreeRepository degreeRepository;
	
	@Autowired
	public LectorServiceImpl(LectorRepository lectorRepository,
								DegreeRepository degreeRepository) {
		
		this.lectorRepository = lectorRepository;
		this.degreeRepository = degreeRepository;
		
	}
		
	@Override
	public List<Integer> getDepartmentStatistic(int departmentId) {
		
		int assistantCount = 0;
		int associateProfessorCount = 0;
		int professorCount = 0;
        
        List<Degree> degrees = degreeRepository.findAll();
        
        List<Lector> lectors = lectorRepository.findAllLectorsFromDepartment(departmentId);
		
        for (Lector lector : lectors) {
        	
        	if (lector.getDegree().getId() == degrees.get(0).getId()) {	
        		assistantCount++;
        	} else if (lector.getDegree().getId() == degrees.get(1).getId()) {
        		associateProfessorCount++;
        	} else if (lector.getDegree().getId() == degrees.get(2).getId()) {
        		professorCount++;
        	}	
        }
        
        List<Integer> degreesCount = new ArrayList<>();
        degreesCount.add(assistantCount);
        degreesCount.add(associateProfessorCount);
        degreesCount.add(professorCount);
        
        return degreesCount;
		
	}

	@Override
	public List<Lector> globalSearch(String str) {
		
		return lectorRepository.globalSearchByFirstNameOrLastNameContainingAllIgnoreCase(str);
		
	}

}
