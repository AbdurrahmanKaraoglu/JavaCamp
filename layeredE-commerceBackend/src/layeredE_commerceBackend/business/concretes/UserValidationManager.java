package layeredE_commerceBackend.business.concretes;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import layeredE_commerceBackend.business.abstracts.UserValidationService;
import layeredE_commerceBackend.entities.concretes.User;

public class UserValidationManager implements UserValidationService {
	Scanner scanner = new Scanner(System.in);
	
	
	private static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	@Override
	public boolean passwordValidation(User user) {
		if (user.getPassword().length() >= 6) {
			return true;
		} else {
			System.out.println("Lütfen Sifrenizi 6 karakter yada daha fazla giriniz.");
			return false;
		}
	}

	
	String emailDatabaseValue = "deneme@hotmail.com";
	
	@Override
	public boolean emailValidation(User user) {
		
		if (user.getEmail() != emailDatabaseValue ) {
			return true;
		}else {
			System.out.println("Bu e-posta adresi daha once kullanilmis!!!");
			return false;
		}
		
		
	}

	@Override
	public boolean emailRegexValidation(User user) {
		Matcher matcher = pattern.matcher(user.getEmail());
		if (matcher.matches()) {
			return true;

		} else {
			System.out.println("Lütfen E-Posta adresinizi dogru giriniz.");
			return false;
		}

	}
	

	@Override
	public boolean firstNameAndLastNameValidation(User user) {
		if (user.getFirstName().length() >= 2 && user.getFirstName().length() >= 2) {
			return true;
		} else {
			System.out.println("Lütfen Ýsim ve Soyisminizi dogru giriniz.");
			return false;
		}

	}

	@Override
	public boolean sendEmail(User user, int code) {
		System.out.print("Lütfen Doðrulama Kodunu Giriniz : ");
		int code_value = scanner.nextInt();
		if (code_value == code) {
			System.out.println("Dogrulama Basarili");
			
			return true;
		} else {
			System.out.println("Dogrulama Basarisiz!!!");
			return false;
		}
	}

}
