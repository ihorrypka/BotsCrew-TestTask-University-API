package com.botscrewcorporation.springboot.application;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.botscrewcorporation.springboot.application.entity.Degree;
import com.botscrewcorporation.springboot.application.entity.Department;
import com.botscrewcorporation.springboot.application.entity.Head;
import com.botscrewcorporation.springboot.application.entity.Lector;
import com.botscrewcorporation.springboot.application.service.degreeservice.DegreeService;
import com.botscrewcorporation.springboot.application.service.departmentservice.DepartmentService;
import com.botscrewcorporation.springboot.application.service.lectorservice.LectorService;

@SpringBootApplication
public class UniversityApplication {
	
	private static Scanner scanner = new Scanner(System.in);
	
	private static DepartmentService departmentService;
	private static LectorService lectorService;
	private static DegreeService degreeService;
	
	@Autowired
	public UniversityApplication(DepartmentService departmentService,
									LectorService lectorService,
									DegreeService degreeService) {
		
		this.departmentService = departmentService;
		this.lectorService = lectorService;
		this.degreeService = degreeService;
		
	}

	public static void main(String[] args) {
		
		SpringApplication.run(UniversityApplication.class, args);
		
		boolean quit = false;
        startApplication();
        printActions();
        while (!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
            
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;

                case 1:
                	Head head = getHeadOfDepartment();
                    break;

                case 2:
                	List<Integer> statistic = getDepartmentStatistic();
                    break;

                case 3:
                	double avgSalary = getAverageSalaryOfDepartment();
                    break;

                case 4:
                	Long employeesCount = getCountOfEmployeeForDepartment();
                    break;

                case 5:
                	List<Lector> lectors = globalSearch();
                    break;

                case 6:
                    printActions();
                    break;
                    
            }
            
        }
        
	}
	
	private static void startApplication() {
		System.out.println();
		System.out.println("Starting application...");
    }
	
	private static void printActions() {
        System.out.println("\nAvailable actions: \npress");
        System.out.println("0 - to shutdown\n" +
                           "1 - to show head of department\n" +
                           "2 - to show department statistic\n" +
                           "3 - to get average salary of department\n" +
                           "4 - to show count of employee for department\n" +
                           "5 - global search\n" +
                           "6 - to print a list of available actions.");
        System.out.println("Choose your actions: ");
    }
	
	public static Head getHeadOfDepartment() {
		
		List<Department> departments = DepartmentInfo();
		
		System.out.println("Please, choose the number of department which head "
													+ "you want to see... ");
		
		int departmentId = scanner.nextInt();
		
		Head theHead = departmentService.getHeadOfDepartment(departmentId);
		
		try {
			
			System.out.println("The head of department " 
					+ departments.get(departmentId - 1).getDepartmnentName() + " is "  
					+ theHead.getFirstName() + " " + theHead.getLastName());
			
		} catch(RuntimeException e) {
			System.out.println("Did not find department id - " + departmentId);
		}
		
		return theHead;
	}
	
	public static List<Integer> getDepartmentStatistic() {
		
		List<Department> departments = DepartmentInfo();
		
		System.out.println("Please, choose the number of department which statistic "
														+ "you want to see... ");
		
		int departmentId = scanner.nextInt();
		
		List<Degree> degrees = degreeService.getAllDegrees();
		
		List<Integer> departmentStatistic = lectorService.getDepartmentStatistic(departmentId);
		
		try {
			
			System.out.println("In department " + departments.get(departmentId - 1)
										.getDepartmnentName() + " there are : ");
			
			for (int i = 0; i < departmentStatistic.size(); i++) {
				
				System.out.println(degrees.get(i).getDegree() + " : " + departmentStatistic.get(i));
				
			}	
			
		} catch(RuntimeException e) {
			System.out.println("Did not find department id - " + departmentId);
		}
		
		return departmentStatistic;
		
	}
	
	public static double getAverageSalaryOfDepartment() {
		
		List<Department> departments = DepartmentInfo();
		
		System.out.println("Please, choose the number of department which "
								+ "average salary you want to see... ");
		
		int departmentId = scanner.nextInt();
		
		double averageSalary = 0.0;
		
		try {
			
			averageSalary = departmentService.getAverageSalaryOfDepartment(departmentId);
			
			System.out.println("The average salary of department " + 
					departments.get(departmentId - 1).getDepartmnentName() + " is " + averageSalary);
			
		} catch(RuntimeException e) {
			System.out.println("Did not find department id - " + departmentId);
		}
		
		return averageSalary;
		
	}
	
	public static long getCountOfEmployeeForDepartment() {
		
		List<Department> departments = DepartmentInfo();
		
		System.out.println("Please, choose the number of department which count of "
											+ "employees you want to see... ");
		
		int departmentId = scanner.nextInt();
		
		long lectorCount = departmentService.getCountOfEmployeeForDepartment(departmentId);
		
		try {
			
			System.out.println("The count lectors of department " 
					+ departments.get(departmentId - 1).getDepartmnentName() 
					+ " is " + lectorCount);
			
		} catch(RuntimeException e) {
			System.out.println("Did not find department id - " + departmentId);
		}
		
		return lectorCount;
		
	}
	
	public static List<Lector> globalSearch() {
		
		System.out.println("Please, enter parametr of search [String==>>] : ");
		
		String str = scanner.nextLine();
		
		List<Lector> seachLectors = lectorService.globalSearch(str);
                
        if (seachLectors.isEmpty()) {
        	System.out.println("There are no lector's names with such parametr!!!");
        } else {       	
        	for (Lector lector : seachLectors) {
        		System.out.println(lector.getFirstName() + " " + lector.getLastName());
        	} 	
        }
        
        return seachLectors;        
        
	}
	
	public static List<Department> getAllDepartments() {
		
		return departmentService.getAllDepartments();
		
	}
	
	public static List<Department> DepartmentInfo() {
		
		System.out.println("There are the following departments : ");
		
		List<Department> departments = getAllDepartments();
		
		departments.forEach(department -> System.out.println(department.getId() + 
				" ==> " + department.getDepartmnentName()));
		
		return departments;
		
	}
						
}
