package com.botscrewcorporation.springboot.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.botscrewcorporation.springboot.application.entity.Department;
import com.botscrewcorporation.springboot.application.entity.Head;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
	@Query(value = "select department.head from Department department "
								+ "where department.id=:departmentId")
	public Head getHeadOfDepartment(@Param("departmentId") int departmentId);
	
	@Query(value = "select avg(lector.salary) from Lector lector join "
										+ "lector.departments department "
										+ "where department.id=:departmentId")
	public double getAverageSalaryOfDepartment(@Param("departmentId") int departmentId);
	
	@Query(value = "select count(department) from Department department "
							+ "join department.lectors where department.id=:departmentId")
	public long getCountOfEmployeeForDepartment(@Param("departmentId") int departmentId);
	
	

}
