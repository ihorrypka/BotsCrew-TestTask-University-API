package com.botscrewcorporation.springboot.application.service.departmentservice;

import java.util.List;

import com.botscrewcorporation.springboot.application.entity.Department;
import com.botscrewcorporation.springboot.application.entity.Head;

public interface DepartmentService {
	
	public List<Department> getAllDepartments();
	
	public Head getHeadOfDepartment(int departmentId);
	
	public double getAverageSalaryOfDepartment(int departmentId);
	
	public long getCountOfEmployeeForDepartment(int departmentId);

}
