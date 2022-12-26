package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;



public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 01: department findById ===");
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("=== TEST 02: department findAll ===");
		List<Department> departments = departmentDao.findAll();
		for(Department obj : departments) {
			System.out.println(obj);
		}
		
		/*System.out.println("=== TEST 03: department insert ===");
		Department newDepartment = new Department(null, "Food");
		departmentDao.insert(newDepartment);
		System.out.println("Insert Completed!");*/
		
		System.out.println("=== TEST 04: department update ===");
		department = departmentDao.findById(3);
		department.setName("Business");
		departmentDao.update(department);
		System.out.println("Update Completed!");
		
		System.out.println("=== TEST 04: department delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed!");
		
		
		
	}

}
