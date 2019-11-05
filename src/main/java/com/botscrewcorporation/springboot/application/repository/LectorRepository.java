package com.botscrewcorporation.springboot.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.botscrewcorporation.springboot.application.entity.Lector;

public interface LectorRepository extends JpaRepository<Lector, Integer> {
	
	@Query(value = "select lector from Lector lector join lector.departments department "
													+ "where department.id=:departmentId")
	List<Lector> findAllLectorsFromDepartment(@Param("departmentId") int departmentId);
	
	@Query(value = "select lector from Lector lector where "
			+ "lector.firstName like %?1% or lector.lastName like %?1%")
	List<Lector> globalSearchByFirstNameOrLastNameContainingAllIgnoreCase(String str);
			

}