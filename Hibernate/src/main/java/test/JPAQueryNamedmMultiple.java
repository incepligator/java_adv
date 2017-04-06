package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.Customer;
import entity.QueryConstants;

public class JPAQueryNamedmMultiple {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf=null;
		EntityManager em=null;
		
		
		
		try {
			
			emf=Persistence.createEntityManagerFactory("OracleUnit");
			em=emf.createEntityManager();
			
			
			
			System.out.println("Connection Establised ");
			
						
			TypedQuery<Customer> query = em.createNamedQuery(QueryConstants.CUSTOMER_SEARCH, Customer.class);
			
			query.setParameter("p1", "swe%");
			query.setParameter("p2", "%");
			
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
