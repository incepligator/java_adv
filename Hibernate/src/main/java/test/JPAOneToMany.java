 package test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Customer;
import entity.CustomerDetails;
import entity.CustomerOrderEntity;

public class JPAOneToMany {

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
			
			CustomerOrderEntity coEntity1= createCustomerOrderEntity();
			CustomerOrderEntity coEntity2= createCustomerOrderEntity();
			
			
			coEntity1.setCustomer(entity);
			coEntity2.setCustomer(entity);
			
			entity.getCustomerOrders().add(coEntity1);
			entity.getCustomerOrders().add(coEntity2);
			
	
			System.out.println("Before"+entity);
			em.persist(entity);
			System.out.println("after"+entity);
			
			
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

/*	private static CustomerDetails createCustomerDetails() {
		
		CustomerDetails entity = new CustomerDetails();
		
		
		entity.setAddress("Test One to one ");
		
		return entity;
	}*/

	private static Customer createCustomer() {
		
		Customer entity= new Customer();
		
		entity.setFirstName("Kabir");
		entity.setLastName("Bijay");
		
		return entity;
	}
	
	private static CustomerOrderEntity createCustomerOrderEntity() {
		
		CustomerOrderEntity entity= new CustomerOrderEntity();
		
		entity.setOrderNumber("ord123"+(Math.random())*1000);
		entity.setCreatedDate(new Date(System.currentTimeMillis()));
		
		return entity;
	}

}
