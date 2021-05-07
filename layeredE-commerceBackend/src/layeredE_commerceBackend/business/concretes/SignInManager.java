package layeredE_commerceBackend.business.concretes;

import layeredE_commerceBackend.business.abstracts.SignInService;
import layeredE_commerceBackend.entities.concretes.User;

public class SignInManager implements SignInService{
	private User user;
	
	public SignInManager(User user) {
		super();
		this.user = user;
	}

	String emailDatabaseValue = "deneme2@hotmail.com";
	String passwordDatabaseValue ="deneme";
	

	@Override
	public void logIn(String email,String password) {
		if (emailDatabaseValue == email && passwordDatabaseValue == password) {
			System.out.println("Giriþ Yapýldý " + user.getFirstName());
		}else {
			System.out.println("Giriþ Baþarýsýz!!!");
		}
		
	}


	

}
