package test;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.Customer;
import entity.QueryConstants;

public class SampleTest {

static	EntityManagerFactory emf;
static 	EntityManager em;
	
	public static void main(String[] args) {
		

		
		emf=Persistence.createEntityManagerFactory("OracleUnit");
		em=emf.createEntityManager();
	
		System.out.println("Connection Established");
		
		TypedQuery<Customer> query = em.createNamedQuery(QueryConstants.BIJAY, Customer.class);
		
		List<Customer> results=query.getResultList();
		
		for (Customer entity:results){
			
			System.out.println(entity);
		}
		
		
		
		System.out.println(Jitu());
		Situ();
		
		em.close();
		emf.close();
		
		//Query q= 
	}
	
	static  Long Jitu(){
		
		
			Long count= (Long) em.createNamedQuery(QueryConstants.CUSTOMER_COUNT).getSingleResult();
		
		    return count;
		    
		    
		    
	}
	
	static  void Situ(){
		
		
		TypedQuery<Customer> query = em.createNamedQuery(QueryConstants.CUSTOMER_SEARCH, Customer.class);
		
		query.setParameter("p1", "swe%");
		query.setParameter("p2", "%");
		
		List<Customer> results=query.getResultList();
		
		for (Customer entity:results){
			
			System.out.println(entity);
		}
	    
}
	
	
	
}
