package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.Customer;

public class JPAQueryTest {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf=null;
		EntityManager em=null;
		
		
		
		try {
			
			emf=Persistence.createEntityManagerFactory("OracleUnit");
			em=emf.createEntityManager();
			
			
			
			System.out.println("Connection Establised ");
			
						
			TypedQuery<Customer> query = em.createQuery("select c from Customer c", Customer.class);
			
			List<Customer> results=query.getResultList();
			
			for (Customer entity:results){
				
				System.out.println(entity);
			}
			
			
	
			
			
			
			
		} catch(Exception e){
			e.printStackTrace();
			
			
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
