package layeredE_commerceBackend.business.concretes;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import layeredE_commerceBackend.business.abstracts.GoogleValidationService;
import layeredE_commerceBackend.entities.concretes.SignUpWithGoogle;

public class GoogleValidationManager implements GoogleValidationService{
	
	Scanner scanner = new Scanner(System.in);

	private static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	@Override
	public boolean googleEmailRegexValidation(SignUpWithGoogle signUpWithGoogle) {
		Matcher matcher = pattern.matcher(signUpWithGoogle.getEmail());
		if (matcher.matches()) {
			return true;

		} else {
			System.out.println("Lütfen E-Posta adresinizi dogru giriniz.");
			return false;
		}
	}

	@Override
	public boolean sendEmail(SignUpWithGoogle signUpWithGoogle,int code) {
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


