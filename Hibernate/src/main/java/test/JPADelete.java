package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Customer;

public class JPADelete {

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
			
			
			
			Customer entity= em.find(Customer.class, new Long(1021));
			
			System.out.println("Before delete "+entity);
			em.remove(entity);
			et.commit();
			
			System.out.println("After delete"+entity);
			
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
