package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST 1: seller findById ===");

		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("=== TEST 2: seller findByDepartment ===");

		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("=== TEST3 : seller findAll ===");

		list = sellerDao.findAll();
		
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("=== TEST4 : seller insert===");

		Seller newSeller = new Seller(null, "Lucas", "lucas@gmail.com", new Date(), 10000.00, dep);
	
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
	
	}

}
