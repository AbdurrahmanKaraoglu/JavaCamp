package layeredE_commerceBackend.business.abstracts;

import layeredE_commerceBackend.entities.concretes.SignUpWithGoogle;

public interface SignUpWithGoogleService {
	void addToGoogle(SignUpWithGoogle signUpWithGoogle); // Kullanici Ekleme
	void update(SignUpWithGoogle signUpWithGoogle); // Kullanici G�ncelleme
	void delete(SignUpWithGoogle signUpWithGoogle); // Kullanici Silme
}
