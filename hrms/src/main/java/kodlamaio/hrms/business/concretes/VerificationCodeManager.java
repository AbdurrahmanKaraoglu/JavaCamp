package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {
	private VerificationCodeDao verificationCodeDao;
	private UserDao userDao;

	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao, UserDao userDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
		this.userDao = userDao;
	}

	@Override
	public String createVerifyCode(User user) {
		String randomCode = UUID.randomUUID().toString();
		// System.out.println("Kod : " + randomCode);
		VerificationCode Code = new VerificationCode();
		Code.setUserId(user);
		Code.setCreatedDate(LocalDate.now());
		Code.setVerifyCode(UUID.randomUUID().toString());
		this.verificationCodeDao.save(Code);

		return randomCode;
	}

	@Override
	public void sendMail(String mail) {

		System.out.println("E-Posta Adresinize Doğrulama Maili Gönderildi : " + mail);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Result verifyUser(String code) {
		if (!this.verificationCodeDao.existsByVerifyCode(code)) {
			return new ErrorResult("Hatalı Doğrulama İşlemi");
		}
		VerificationCode newVerificationCode = verificationCodeDao.getByVerifyCode(code);
		if (this.verificationCodeDao.getOne(newVerificationCode.getId()).isConfirmed()) {
			return new ErrorResult("Doğrulama işlemi daha önce yapıldı");
		}
		newVerificationCode.setConfirmed(true);
		newVerificationCode.setConfirmedDate(LocalDate.now());
		verificationCodeDao.save(newVerificationCode);
		User verificationUser = new User();
		verificationUser = userDao.getOne(newVerificationCode.getUserId().getId());
		verificationUser.setVerify(true);
		userDao.save(verificationUser);
		return new SuccessResult("Doğrulama Başarılı");

	}
}