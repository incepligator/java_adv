package entity;

public class AbstractListener {
	
	
	private String password ="secrect";
	
	protected String getPassword(){
		return password;
		
	}

	proctes String encrypt (final String value){
		
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(getPassword());
		return encryptor.encrypt(message);
		
	}
	
}
