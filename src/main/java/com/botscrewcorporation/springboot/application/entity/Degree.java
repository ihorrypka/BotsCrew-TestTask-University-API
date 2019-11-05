package com.botscrewcorporation.springboot.application.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="degree")
public class Degree {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="degree")
	private String degree;
	
	@OneToMany(mappedBy="degree", fetch = FetchType.LAZY,
					cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
					CascadeType.REFRESH})
	private List<Lector> lectors;
		
	public Degree() {
		
	}
	
	public Degree(int id, String degree) {
		this.id = id;
		this.degree = degree;
	}
	
	public Degree(String degree) {
		this.degree = degree;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public List<Lector> getLector() {
		return lectors;
	}

	public void setLector(List<Lector> lectors) {
		this.lectors = lectors;
	}

	@Override
	public String toString() {
		return "Degree [id=" + id + ", degree=" + degree + "]";
	}
	
}
