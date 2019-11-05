package com.botscrewcorporation.springboot.application.service.departmentservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.botscrewcorporation.springboot.application.entity.Department;
import com.botscrewcorporation.springboot.application.entity.Head;
import com.botscrewcorporation.springboot.application.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;
	
	@Autowired
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
	
	@Override
	public List<Department> getAllDepartments() {
		
		return departmentRepository.findAll();
		
	}
	
	@Override
	public Head getHeadOfDepartment(int departmentId) {
		
		return departmentRepository.getHeadOfDepartment(departmentId);
		
	}

	@Override
	public double getAverageSalaryOfDepartment(int departmentId) {
		
		return departmentRepository.getAverageSalaryOfDepartment(departmentId);
		
	}

	@Override
	public long getCountOfEmployeeForDepartment(int departmentId) {
		
		return departmentRepository.getCountOfEmployeeForDepartment(departmentId);
					
	}

}
