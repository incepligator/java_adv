package test;

import entity.Customer;
import entity.Student;

public class JPATwoTableCreate {

	public static void main(String[] args) {
		
		
		ConnectionTest twowrite= new ConnectionTest();
		twowrite.connect();
		
		try {
					
			System.out.println("Connection Establised JPA2");
			
			
			Customer entity= new Customer();
			
			entity.setFirstName("Kabir");
			entity.setLastName("Shretha");
			
			System.out.println("Before Save Customer"+entity);
			
			
			twowrite.em.persist(entity);
			
			System.out.println("After Save Customer"+entity);
			
			
			
			Student sentity= new Student();
			
			sentity.setFirstName("Kabir");
			sentity.setLastName("Shrestha");
			sentity.setAddress("Colorado");
			sentity.setPhone(984146314);
			
			
			System.out.println("Before Save Student"+sentity);
			
			
			twowrite.em.persist(sentity);
			
			System.out.println("After Save Customer"+sentity);
			
			twowrite.et.commit();
			
			
			
		} catch(Exception e){
			e.printStackTrace();
			twowrite.et.rollback();
			
		}
		finally{
			if(twowrite.em!=null){
				
				twowrite.em.close();
			}
			if(twowrite.emf!=null){
				
				twowrite.emf.close();
			}
		}

	}

}

