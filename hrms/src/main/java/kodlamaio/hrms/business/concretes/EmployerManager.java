package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.base.Strings;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.validations.EmployerValidator;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;

@Service // 5 -- Bu class projede servis görevi görecek
public class EmployerManager implements EmployerService {

	// Birden fazla olabilir.
	private EmployerDao employerDao; // 2 -- Veri tabanına erişmek için
	private UserDao userDao;
	private VerificationCodeService verificationCodeService;

	@Autowired // 3 -- Bağımlılık oluşturur.
	public EmployerManager(EmployerDao employerDao, UserDao userDao, VerificationCodeService verificationCodeService) { // 4
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
		this.verificationCodeService = verificationCodeService;
	}

	@Override // 1
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data Listelendi");
	}

	@Override // 1
	public Result add(Employer employer) {

		if (getByEmail(employer.getEmail()).getData() != null) {
			return new ErrorResult(employer.getEmail() + " E-Posta Adresinden Daha Önceden Bir Kayıt Var.");
		} else if (!EmployerValidator.EmployerDomainCheck(employer)) {
			return new ErrorResult("Eşleşmeyen Domain adreis ile eposta adresi");
		}

		else if (isEmailValid(employer.getEmail())) {

			User savedUser = this.employerDao.save(employer);

			// this.employerDao.save(employer);
			// return new SuccessResult("İş Veren Eklendi");
			this.verificationCodeService.createActivationCode(savedUser);
			return new SuccessResult(employer.getEmail() + " Adresine doğrulama kodu gönderildi");

		}

		else {

			return new ErrorResult("Kullanıcı Bilgileri Hatalı");

		}

	}

	private final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

	public boolean isEmailValid(String emailInput) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(emailInput).find();
	}

	@Override
	public DataResult<Employer> getByCompanyName(String companyName) {
		return new SuccessDataResult<Employer>(this.employerDao.getByCompanyName(companyName), "Data listelendi");
	}

	@Override
	public DataResult<Employer> getByEmail(String email) {
		return new SuccessDataResult<Employer>(this.employerDao.getByEmail(email), "Data listelendi");
	}

}