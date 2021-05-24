package layeredE_commerceBackend;

import layeredE_commerceBackend.business.abstracts.SignInService;
import layeredE_commerceBackend.business.abstracts.SignUpWithGoogleService;
import layeredE_commerceBackend.business.abstracts.UserService;
import layeredE_commerceBackend.business.concretes.UserValidationManager;
import layeredE_commerceBackend.business.concretes.GoogleValidationManager;
import layeredE_commerceBackend.business.concretes.SignInManager;
import layeredE_commerceBackend.business.concretes.SignUpWithGoogleManager;
import layeredE_commerceBackend.business.concretes.UserManager;
import layeredE_commerceBackend.dataAccess.concretes.HibernateGoogleDao;
import layeredE_commerceBackend.dataAccess.concretes.HibernateUsersDao;
import layeredE_commerceBackend.entities.concretes.SignUpWithGoogle;
import layeredE_commerceBackend.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		// ------------------------------ Kullanici Bilgileri Ile Uye Olma --------------------------------------
		
		UserService usersService = new UserManager(new UserValidationManager(),new HibernateUsersDao());
		
		User users1 = new User(1, "Abdurrahman", "Karaoðlu", "deneme@hotmail.com", "deneme");
		User users2 = new User(2, "Ahmet", "Özberk", "deneme2@hotmail.com", "deneme");
		
		User users3 = new User(3, "Ömer", "Doðan", "deneme@.com", "deneme");
		User users4 = new User(4, "Ali", "Veli", "deneme3@hotmail", "deneme");
		
		
		usersService.add(users1);
		System.out.println("----------------------------------------------------\n");
		usersService.add(users2);
		System.out.println("----------------------------------------------------\n");
		usersService.add(users3);
		System.out.println("----------------------------------------------------\n");
		usersService.add(users4);
		System.out.println("----------------------------------------------------\n");
		
		// ------------------------------ Google Ile Uye Olma --------------------------------------
		
		SignUpWithGoogleService googleService = new SignUpWithGoogleManager(new GoogleValidationManager(),new HibernateGoogleDao());
		SignUpWithGoogle signUpWithGoogle = new SignUpWithGoogle("deneme5@hotmail.com", "deneme");
		
		googleService.addToGoogle(signUpWithGoogle);
		System.out.println("----------------------------------------------------\n");
		
		// ------------------------------ Sisteme Giris --------------------------------------
		
		SignInService signInService = new SignInManager(users2);
		
		signInService.logIn(users2.getEmail(), users2.getPassword());
		

	}
}