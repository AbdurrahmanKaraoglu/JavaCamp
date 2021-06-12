package kodlamaio.hrms.business.validationRules;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.ConfirmEmployerService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerVerificationManager implements VerificationService<Employer> {

	private EmployerDao employerDao;
	private UserDao userDao;
	private VerificationCodeService verificationCodeService;
	private ConfirmEmployerService confirmEmployerService; 

	@Autowired
	public EmployerVerificationManager(EmployerDao employerDao, UserDao userDao,
			VerificationCodeService verificationCodeService,ConfirmEmployerService confirmEmployerService) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
		this.verificationCodeService = verificationCodeService;
		this.confirmEmployerService = confirmEmployerService;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Result verifyData(Employer employer) {

		if (this.userDao.existsByEmail(employer.getEmail())) {
			return new ErrorResult(employer.getEmail() + " E-Posta Adresinden Daha Önceden Bir Kayıt Var.");
		}
		if (!EmployerEmailValidator.EmployerDomainCheck(employer)) {
			return new ErrorResult("Eşleşmeyen Domain adreis ile eposta adresi");
		}

		if (!IsEmailValidManager.isEmailValid(employer.getEmail())) {
			return new ErrorResult("Lütfen Geçerli Bir Mail Adresi Giriniz");
		}
		if (!employer.getPassword().equals(employer.getPasswordRepeat())) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}

		this.employerDao.save(employer);	
		this.verificationCodeService.createVerifyCode(userDao.getOne(employer.getId()));
		this.verificationCodeService.sendMail(employer.getEmail());
		this.confirmEmployerService.createConfirmEmployer(employer);
		
		return new SuccessResult("İşveren Eklendi");

	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Listeleme Başarılı");
	}
}
