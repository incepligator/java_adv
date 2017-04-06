package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Customer;
import entity.Student;






public class Query1 {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf=null;
		EntityManager em=null;
		
		
		
		try {
			
			emf=Persistence.createEntityManagerFactory("OracleUnit");
			em=emf.createEntityManager();
			
						
			System.out.println("Results ------------");
			
			  Query query = em.createNamedQuery("find Customer by id");
			  Query squery = em.createNamedQuery("find Student by ph");
			      
			 //     query.setParameter("id", new Long(1009));
			      
			      query.setParameter("id", ("Kabir"));
			      
			      squery.setParameter("ph", new Long(44213852));
			      
			      List<Customer> list = query.getResultList();
			      List<Student> slist=squery.getResultList();
			      
			      for(Customer e:list ){
			    	  System.out.println(e);
			       
			      }
			for(Student e:slist){
				
				 System.out.println(e);
		        
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
