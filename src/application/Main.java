package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Main {

	public static void main(String[] args) {
		
		Scanner ent = new Scanner(System.in);
		SellerDao sd = DaoFactory.createSellerDao();
		
		System.out.println("==== TESTE 1: seller findById (departamento 3) ====");
		Seller seller = sd.findById(3);
		System.out.println(seller);
		
		System.out.println("\n==== TESTE 2: seller findByDepartment (departamento 6 e 2) ====");
		Department department = new Department(2, null);
		List<Seller> list = sd.findbyDepartment(department);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TESTE 3: seller findByAll (todos os vendedores) ====");
		list = sd.findAll();
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
//		System.out.println("\n==== TESTE 4: seller insert (inser��o de dados) ====");
//		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4500.00, department);
//		
//		sd.insert(newSeller);
//		System.out.println("Inserido com sucesso! > Novo ID = " + newSeller.getId());
		
//		System.out.println("\n==== TESTE 5: seller update (atualiza��o de dados) ====");
//		seller = sd.findById(1);
//		//seller.setName("Maria Marta");
//		seller.setEmail("mariamarta@gmail.com");
//		sd.update(seller);
//		System.out.println("Atualiza��o feita com sucesso!");
		
		System.out.println("\n==== TESTE 6: seller delete (dele��o de vendedor por ID) ====");
		System.out.print("Informe um ID para dele��o: ");
		int id = ent.nextInt();
		sd.deleteById(id);
		System.out.println("Dele��o feita com sucesso!");
		
		ent.close();
	}

}
