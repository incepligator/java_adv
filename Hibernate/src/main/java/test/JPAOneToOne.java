 package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Customer;
import entity.CustomerDetails;

public class JPAOneToOne {

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
			
			Customer entity= createCustomer();
			
			CustomerDetails details= createCustomerDetails();
			
			entity.setCustomerDetails(details);
			details.setCustomer(entity);
			
			em.persist(entity);
			
	
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

	private static CustomerDetails createCustomerDetails() {
		
		CustomerDetails entity = new CustomerDetails();
		
		
		entity.setAddress("Test One to one ");
		
		return entity;
	}

	private static Customer createCustomer() {
		
		Customer entity= new Customer();
		
		entity.setFirstName("shrawan ");
		entity.setLastName("shrestha");
		
		return entity;
	}

}
