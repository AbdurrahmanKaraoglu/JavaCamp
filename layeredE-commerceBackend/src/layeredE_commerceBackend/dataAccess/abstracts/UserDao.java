package layeredE_commerceBackend.dataAccess.abstracts;
import java.util.List;
import layeredE_commerceBackend.entities.concretes.User;

public interface UserDao {
	void add(User users); // Kullanici Ekleme
	void update(User users); // Kullanici Güncelleme
	void delete(User users); // Kullanici Silme
	User getId(int id); // Kullanici Arama
	User getEmailPassword(String email,String password);
	User getEmail(String email);
	List<User> getAll(); // Kullanici Listeleme 
}
