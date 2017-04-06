package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

import entity.QueryConstants;

public class JPAQueryNamedCount {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf=null;
		EntityManager em=null;
		
		
		
		try {
			
			emf=Persistence.createEntityManagerFactory("OracleUnit");
			em=emf.createEntityManager();
			
			
			
			System.out.println("Connection Establised ");
			
		Long count= (Long) em.createNamedQuery(QueryConstants.CUSTOMER_COUNT).getSingleResult();
		
		System.out.println("Count"+count);
			
		
			
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
