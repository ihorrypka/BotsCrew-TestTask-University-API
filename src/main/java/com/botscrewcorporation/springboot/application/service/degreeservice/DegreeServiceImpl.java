package com.botscrewcorporation.springboot.application.service.degreeservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.botscrewcorporation.springboot.application.entity.Degree;
import com.botscrewcorporation.springboot.application.repository.DegreeRepository;

@Service
public class DegreeServiceImpl implements DegreeService{
	
	private DegreeRepository degreeRepository;
	
	@Autowired
	public DegreeServiceImpl(DegreeRepository degreeRepository) {
		this.degreeRepository = degreeRepository;
	}

	@Override
	public List<Degree> getAllDegrees() {
		
		return degreeRepository.findAll();
		
	}

}
