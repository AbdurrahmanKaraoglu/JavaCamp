package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;

public interface VerificationCodeService {
	Result verifyUser(String code);

	String createVerifyCode(User user);

	void sendMail(String mail);

}