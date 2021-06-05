package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.base.Strings;
import kodlamaio.hrms.business.abstracts.FakeEmailVerificationService;
import kodlamaio.hrms.business.abstracts.JobSeekerCheckService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.MernisDemoService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {
	private JobSeekerDao jobSeekerDao;
	private UserDao userDao;
	private VerificationCodeService verificationCodeService;
	private MernisDemoService mernisDemoService;
	private FakeEmailVerificationService fakeEmailVerificationService;
	private JobSeekerCheckService jobSeekerCheckService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, UserDao userDao, VerificationCodeService verificationCodeService,
			MernisDemoService mernisDemoService, FakeEmailVerificationService fakeEmailVerificationService,
			JobSeekerCheckService jobSeekerCheckService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.userDao = userDao;
		this.verificationCodeService = verificationCodeService;
		this.mernisDemoService = mernisDemoService;
		this.fakeEmailVerificationService = fakeEmailVerificationService;
		this.jobSeekerCheckService = jobSeekerCheckService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		// System.out.println("Burda3");
		// if (jobSeekerCheckService.CheckIfRealJobSeeker(jobSeeker))
		// {
		// return new ErrorResult("TC Kimlik dogrulamasi yapilamadi");
		// }
		// System.out.println("Burda4");
		/*
		 * if (Strings.isNullOrEmpty(jobSeeker.getFirstName())) { return new
		 * ErrorResult("Lütfen İsminizi Boş Geçmeyiniz"); }
		 * 
		 * else if (Strings.isNullOrEmpty(jobSeeker.getLastName())) { return new
		 * ErrorResult("Lütfen Soyisminizi Boş Geçmeyiniz"); }
		 * 
		 * else if (jobSeeker.getDateOfBirth() <= 0) { // Düzenleme yapılacak return new
		 * ErrorResult("Lütfen dogum yilini Boş Geçmeyiniz"); }
		 * 
		 * else if (jobSeeker.getEmail() == null) { return new
		 * ErrorResult("Lütfen email adresinizi Boş Geçmeyiniz"); }
		 * 
		 * else if (jobSeeker.getPassword().length() <= 6) { return new
		 * ErrorResult("Lütfen sifrenizi 6 karakterden az girmeyiniz"); }
		 */
		// else if
		// (!mernisDemoService.isValidNationolityIdentity(jobSeeker.getIdentificationNumber()))
		// else if (jobSeekerCheckService.CheckIfRealPerson(jobSeeker))
		// {
		// return new ErrorResult("TC Kimlik dogrulamasi yapilamadi");
		// }
		// else
		if (getByEmail(jobSeeker.getEmail()).getData() != null) {
			return new ErrorResult(jobSeeker.getEmail() + " E-Posta Adresinden Daha Önceden Bir Kayıt Var.");
		} else if (getByIdentificationNumber(jobSeeker.getIdentificationNumber()).getData() != null) {
			return new ErrorResult(jobSeeker.getIdentificationNumber() + " Tc No dan Daha Önceden Bir Kayıt Var.");
		} else if (isEmailValid(jobSeeker.getEmail())) {

			// new SuccessResult(jobSeeker.getEmail() + " Adresine doğrulama kodu
			// gönderildi");
			// Düzenleme yapılacak.

			// jobSeeker.setMailVerify(false);

			if (fakeEmailVerificationService.emailVerification(jobSeeker.getEmail())) {
				User savedUser = this.userDao.save(jobSeeker);
				this.verificationCodeService.createActivationCode(savedUser);
				this.jobSeekerDao.save(jobSeeker);
				return new SuccessResult("İş Arayan Eklendi");
			} else {
				return new ErrorResult(jobSeeker.getEmail() + " E-Posta Adresi Doğrulanamadı.");
			}

		}

		else {

			return new ErrorResult("Kullanıcı bilgileri hatalı");
		}

	}

	private final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

	public boolean isEmailValid(String emailInput) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(emailInput).find();
	}

	@Override
	public DataResult<JobSeeker> getByIdentificationNumber(String identificationNumber) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getByIdentificationNumber(identificationNumber),
				"Data listelendi");
	}

	@Override
	public DataResult<JobSeeker> getByEmail(String email) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getByEmail(email), "Data listelendi");
	}

}
