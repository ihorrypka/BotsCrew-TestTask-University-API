package com.botscrewcorporation.springboot.application.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="department_name")
	private String departmnentName;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="head_id")
	private Head head; 
	
	@ManyToMany
	@JoinTable(
			name="department_lector",
			joinColumns=@JoinColumn(name="department_id"),
			inverseJoinColumns=@JoinColumn(name="lector_id")
			)
	private List<Lector> lectors;
		
	public Department() {
		
	}
	
	public Department(String departmnentName) {
		this.departmnentName = departmnentName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmnentName() {
		return departmnentName;
	}

	public void setDepartmnentName(String departmnentName) {
		this.departmnentName = departmnentName;
	}

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public List<Lector> getLectors() {
		return lectors;
	}

	public void setLectors(List<Lector> lectors) {
		this.lectors = lectors;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmnentName=" + departmnentName + "]";
	}

}
