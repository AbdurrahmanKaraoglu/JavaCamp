package kodlamaio.hrms.business.validationRules;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerVerificationManager implements VerificationService<JobSeeker> {

	private JobSeekerDao jobSeekerDao;
	private UserDao userDao;
	private VerificationCodeService verificationCodeService;

	@Autowired
	public JobSeekerVerificationManager(JobSeekerDao jobSeekerDao, UserDao userDao,
			VerificationCodeService verificationCodeService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.userDao = userDao;
		this.verificationCodeService = verificationCodeService;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Result verifyData(JobSeeker jobSeeker) {
		/*
		 * Mernis Kimlik Doğrulaması Yapılacak if
		 * (!this.jobSeekerCheckService.CheckIfRealJobSeeker(jobSeeker)) { return new
		 * ErrorResult("Mernis Kimlik Doğrulaması Başarısız Oldu"); }
		 */
		if (this.userDao.existsByEmail(jobSeeker.getEmail())) {
			return new ErrorResult(jobSeeker.getEmail() + " E-Posta Adresinden Daha Önceden Bir Kayıt Var.");
		}

		if (this.jobSeekerDao.existsByIdentificationNumber(jobSeeker.getIdentificationNumber())) {
			return new ErrorResult(jobSeeker.getIdentificationNumber() + " Tc No dan Daha Önceden Bir Kayıt Var.");
		}

		if (!jobSeeker.getPassword().equals(jobSeeker.getPasswordRepeat())) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		if (!IsEmailValidManager.isEmailValid(jobSeeker.getEmail())) {
			return new ErrorResult("Lütfen Geçerli Bir Mail Adresi Giriniz");
		}

		this.jobSeekerDao.save(jobSeeker);
		this.verificationCodeService.createVerifyCode(userDao.getOne(jobSeeker.getId()));
		this.verificationCodeService.sendMail(jobSeeker.getEmail());
		return new SuccessResult("İş Arayan Eklendi");
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Listeleme Başarılı");

	}

}