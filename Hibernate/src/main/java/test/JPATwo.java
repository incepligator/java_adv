package test;

import entity.Customer;
import entity.Student;

public class JPATwo {

	public static void main(String[] args) {
		
		
		ConnectionTest twowrite= new ConnectionTest();
		twowrite.connect();
		
		try {
					
			System.out.println("Connection Establised JPA2");
			
			
			Customer entity= new Customer();
			
			entity.setFirstName("Sweet2");
			entity.setLastName("Heart2");
			
			System.out.println("Before Save Customer"+entity);
			
			
			twowrite.em.persist(entity);
			
			System.out.println("After Save Customer"+entity);
			
			
			
			Student sentity= new Student();
			
			sentity.setFirstName("Sweet2");
			sentity.setLastName("Heart2");
			sentity.setAddress("Irving2");
			sentity.setPhone(44213852);
			
			
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

