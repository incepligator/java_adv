package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Customer;

public class JPACreateTest {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf=null;
		EntityManager em=null;
		EntityTransaction et=null;
		
		
		try {
			
			emf=Persistence.createEntityManagerFactory("OracleUnit");
			em=emf.createEntityManager();
			et=em.getTransaction();
			et.begin();
			
			System.out.println("Connection Establised ");
			
			Customer entity= new Customer();
			
			entity.setFirstName("Sweet");
			entity.setLastName("Is More");
			
			System.out.println("Before Save"+entity);
			em.persist(entity);
			
			System.out.println("After Save"+entity);
			
			
			
			et.commit();
			
			
			
			
			
		} catch(Exception e){
			e.printStackTrace();
			et.rollback();
			
		}
		finally{
			if(em!=null){
				
				em.close();
			}
			if(emf!=null){
				
				emf.close();
			}
		}

	}

}
