package test;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.QueryConstants;

public class JPAQueryNamedNative2 {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf=null;
		EntityManager em=null;
		
		try {
			
			emf=Persistence.createEntityManagerFactory("OracleUnit");
			em=emf.createEntityManager();
			
			System.out.println("Connection Establised ");
			
			Query q=em.createNamedQuery(QueryConstants.NATIVE_CUSTOMER_SEARCH);
			
			q.setParameter(1,"Swe%");
			
			List<Object[]> results= (List<Object[]>) q.getResultList();
			
			for (Object[] eachRow:results){
				
				System.out.println(eachRow[0] +" "+ eachRow[1]);
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
