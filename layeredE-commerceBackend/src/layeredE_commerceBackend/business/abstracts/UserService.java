package layeredE_commerceBackend.business.abstracts;

import java.util.List;

import layeredE_commerceBackend.entities.concretes.User;

public interface UserService {
	void add(User user); // Kullanici Ekleme
	void update(User user); // Kullanici Güncelleme
	void delete(User user); // Kullanici Silme
	User getEmail(String email);
	User getId(int id); // Kullanici Arama
	List<User> getAll(); // Kullanici Listeleme 
	
}
