package layeredE_commerceBackend.dataAccess.abstracts;

import java.util.List;

import layeredE_commerceBackend.entities.concretes.SignUpWithGoogle;
import layeredE_commerceBackend.entities.concretes.User;

public interface GoogleDao {
	void add(SignUpWithGoogle signUpWithGoogle); // Kullanici Ekleme
	void update(SignUpWithGoogle signUpWithGoogle); // Kullanici Güncelleme
	void delete(SignUpWithGoogle signUpWithGoogle); // Kullanici Silme
	User getId(int id); // Kullanici Arama
	User getEmailPassword(String email,String password);
	User getEmail(String email);
	List<User> getAll(); // Kullanici Listeleme 
}
