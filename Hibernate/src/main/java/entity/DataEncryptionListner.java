package entity;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

public class DataEncryptionListner {

	
	@PrePersist
	public void logBeforePersist(final Customer entity){
		
		
		
		System.out.println("Pre Persist = " +entity);
		entity.setLastName(this.encrypt(entity.getLastName()));
	}
	
	
	
	@PostPersist
	public void logAfterPersist(final Customer entity){
		
		
		System.out.println("Post Persist = " +entity);
	}
	
	
}
