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

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private VerificationCodeService verificationCodeService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, VerificationCodeService verificationCodeService) { // 4
		super();
		this.employerDao = employerDao;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(Employer employer) {
		if (Strings.isNullOrEmpty(employer.getCompanyName())) {
			return new ErrorResult("Lütfen Firma İsmini Giriniz!!!");
		} else if (Strings.isNullOrEmpty(employer.getWebAddress())) {
			return new ErrorResult("Lütfen Web Adresini  Giriniz!!!");
		} else if (Strings.isNullOrEmpty(employer.getPhoneNumber())) {
			return new ErrorResult("Lütfen Telefon Numarasını Giriniz!!!");
		} else if (Strings.isNullOrEmpty(employer.getEmail())) {
			return new ErrorResult("Lütfen Email i Giriniz!!!");
		} else if (Strings.isNullOrEmpty(employer.getPassword()) && employer.getPassword().length() <= 6) {
			return new ErrorResult("Lütfen Şifrenizi 6 Karakterden Az  Girmeyiniz!!!");
		} else if (getByEmail(employer.getEmail()).getData() != null) {
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
