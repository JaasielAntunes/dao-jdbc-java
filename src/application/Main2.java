package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Main2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TESTE 1: buscar por id =======");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);

		System.out.println("\n=== TESTE 2: buscar tudo =======");
		List<Department> list = departmentDao.findAll();
		
		for (Department d : list) {
			System.out.println(d);
		}

		System.out.println("\n=== TESTE 3: inser��o =======");
		Department newDepartment = new Department(null, "M�sica");
		
		departmentDao.insert(newDepartment);
		System.out.println("Inserido com sucesso! Novo ID: " + newDepartment.getId());

		System.out.println("\n=== TESTE 4: atualiza��o =======");
		Department dep2 = departmentDao.findById(1);
		
		dep2.setName("Alimentos");
		departmentDao.update(dep2);
		System.out.println("Atualiza��o feita com sucesso!");

		System.out.println("\n=== TESTE 5: dele��o =======");
		System.out.print("Informe um ID para ser deletado: ");
		int id = sc.nextInt();
		
		departmentDao.deleteById(id);
		System.out.println("Dele��o feita com sucesso!");

		sc.close();

	}

}
