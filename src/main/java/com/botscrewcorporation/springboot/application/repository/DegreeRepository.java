package com.botscrewcorporation.springboot.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.botscrewcorporation.springboot.application.entity.Degree;

public interface DegreeRepository extends JpaRepository<Degree, Integer> {

}
