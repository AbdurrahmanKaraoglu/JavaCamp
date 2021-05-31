package kodlamaio.hrms.core.validations;

import kodlamaio.hrms.entities.concretes.Employer;

public class EmployerValidator {

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