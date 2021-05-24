package layeredE_commerceBackend.business.abstracts;

import layeredE_commerceBackend.entities.concretes.User;

public interface UserValidationService {
	boolean passwordValidation(User user);
	boolean emailValidation(User user);
	boolean emailRegexValidation(User user);
	boolean firstNameAndLastNameValidation(User user);
	boolean sendEmail(User user,int code);

}
