package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 01: seller findById ===");
		Seller seller = sellerDao.findById(4);
		System.out.println(seller);
		
		System.out.println("=== TEST 02: seller findByDepartment ===");
		Department department = new Department(3, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list){
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 03: seller findAll ===");
		list = sellerDao.findAll();
		for(Seller obj : list){
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 04: seller insert ===");
		Seller newSeller = new Seller(null, "Bruno Marinelli", "brunomarinelli@gmail.com", new Date(), 5400.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("=== TEST 05: seller update ===");
		seller = sellerDao.findById(2);
		seller.setName("Thalia Freitas");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("=== TEST 06: seller delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
		
	}

}
