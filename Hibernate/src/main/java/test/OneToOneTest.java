package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Customer;
import entity.Student;

public class OneToOneTest {

	public static void main(String[] args) {
		

		Customer c= new Customer();
			
		EntityManagerFactory emf=null;
		EntityManager em=null;
		
				
			emf=Persistence.createEntityManagerFactory("OracleUnit");
			em=emf.createEntityManager();
			
			System.out.println("Connection Establised ");
			
			
			em.getTransaction().begin();
			
			
			
			
			
			
			
			
		
	}

}
