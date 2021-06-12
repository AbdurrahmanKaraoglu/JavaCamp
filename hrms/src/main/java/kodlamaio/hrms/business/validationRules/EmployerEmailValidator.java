package kodlamaio.hrms.business.validationRules;

import org.springframework.stereotype.Service;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerEmailValidator {
	public static boolean EmployerDomainCheck(Employer employer) {

		String[] dizi = employer.getEmail().split("@");
		String email = dizi[1];

		String[] dizi2 = employer.getWebAddress().split("www.");
		String domain = dizi2[1];

		if (email.equals(domain))
			return true;
		else
			return false;
	}
}
