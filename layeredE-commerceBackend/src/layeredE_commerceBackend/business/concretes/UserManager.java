package layeredE_commerceBackend.business.concretes;

import java.util.List;

import layeredE_commerceBackend.business.abstracts.UserService;
import layeredE_commerceBackend.dataAccess.abstracts.UserDao;
import layeredE_commerceBackend.entities.concretes.User;

public class UserManager implements UserService {

	private UserValidationManager userValidation;
	private UserDao userDao;
	

	public UserManager(UserValidationManager userValidation, UserDao userDao) {
		super();
		this.userValidation = userValidation;
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		if (userValidation.emailRegexValidation(user) == true
				&& userValidation.firstNameAndLastNameValidation(user) == true
				&& userValidation.passwordValidation(user) == true
				&& userValidation.emailValidation(user) == true) {
			
			int code_value = (int)(Math.random()*10001);
			
			System.out.println("Dogrulama Mail'i Gonderildi ");
			System.out.println("Dogrulama Kodu : "+ code_value);
			
			if (userValidation.sendEmail(user, code_value) == true) {
				this.userDao.add(user);
			}
			
			
		}else {
			System.out.println("Kullanici Ekleme Ýslemi Baþarýsýz!!!");
		}
	}
	

	@Override
	public void update(User user) {
		if (userValidation.emailRegexValidation(user) == true
				&& userValidation.firstNameAndLastNameValidation(user) == true
				&& userValidation.passwordValidation(user) == true
				&& userValidation.emailValidation(user) == true) {
			
			this.userDao.add(user);
			System.out.println("Kullanici Guncellendi : "+ user.getFirstName());
		}else {
			System.out.println("Kullanici Guncelleme Ýslemi Basarisiz!!!");
		}
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullanici Silindi.");
	}
	

	@Override
	public User getId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
