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

		System.out.println("==== TEST1: department insert");

		Department department = new Department(null, "Loucura Novo");

		departmentDao.insert(department);

		System.out.println("Inserted! New id = " + department.getId());

		System.out.println("==== TEST2: department update");

		department.setName("Loucura Update");
		departmentDao.update(department);

		System.out.println("Update completed");
		
		System.out.println("==== TEST3: department deleted");
		System.out.println("digite o id de um departmento a ser deletado:");
		int id = sc.nextInt();
		departmentDao.deleteById(id);

		System.out.println("Delete completed");

		System.out.println("==== TEST4: department findById");
		Department dep = departmentDao.findById(1);
		
		System.out.println(dep);
		
		System.out.println("==== TEST5: department findAll");
		List<Department> list = departmentDao.findAll();
		
		for (Department obj : list) {
			System.out.println(obj);
		}
		sc.close();
		
	}

}
