package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
	DataResult<List<VerificationCode>> getAll(); // Tüm verileri listelemek için

	Result add(VerificationCode verificationCode);

	String createActivationCode(User user);

	VerificationCode findByCode(String code);
}
