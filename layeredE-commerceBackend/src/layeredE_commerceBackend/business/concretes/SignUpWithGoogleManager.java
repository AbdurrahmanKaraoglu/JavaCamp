package layeredE_commerceBackend.business.concretes;


import layeredE_commerceBackend.business.abstracts.SignUpWithGoogleService;
import layeredE_commerceBackend.dataAccess.abstracts.GoogleDao;
import layeredE_commerceBackend.entities.concretes.SignUpWithGoogle;


public class SignUpWithGoogleManager implements SignUpWithGoogleService{
	
	private GoogleValidationManager signUpWithGoogleValidation;
	private GoogleDao googleDao;
	
	

	public SignUpWithGoogleManager(GoogleValidationManager signUpWithGoogleValidation, GoogleDao googleDao) {
		super();
		this.signUpWithGoogleValidation = signUpWithGoogleValidation;
		this.googleDao = googleDao;
	}

	@Override
	public void addToGoogle(SignUpWithGoogle signUpWithGoogle) {
	
		if (signUpWithGoogleValidation.googleEmailRegexValidation(signUpWithGoogle) == true) {
					
					int code_value = (int)(Math.random()*10001);
					
					System.out.println("Dogrulama Mail'i Gonderildi ");
					System.out.println("Dogrulama Kodu : "+ code_value);
					
					if (signUpWithGoogleValidation.sendEmail(signUpWithGoogle, code_value) == true) {
						this.googleDao.add(signUpWithGoogle);
					}
					
					
				}else {
					System.out.println("Kullanici Ekleme Ýslemi Baþarýsýz!!!");
				}

		
	}

	@Override
	public void update(SignUpWithGoogle signUpWithGoogle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SignUpWithGoogle signUpWithGoogle) {
		System.out.println("Kullanici Silindi.");
		
	}


}
