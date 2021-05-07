package layeredE_commerceBackend.business.abstracts;

import layeredE_commerceBackend.entities.concretes.SignUpWithGoogle;

public interface GoogleValidationService {
	boolean googleEmailRegexValidation(SignUpWithGoogle signUpWithGoogle);
	boolean sendEmail(SignUpWithGoogle signUpWithGoogle,int code);
}
