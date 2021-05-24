package layeredE_commerceBackend.dataAccess.concretes;

import java.util.List;

import layeredE_commerceBackend.dataAccess.abstracts.UserDao;
import layeredE_commerceBackend.entities.concretes.User;

public class AbcProductDao implements UserDao{

	@Override
	public void add(User users) {
		System.out.println("AbcProductDao ile eklendi "+ users.getFirstName());
		
	}

	@Override
	public void update(User users) {
		System.out.println("AbcProductDao ile güncellendi "+ users.getFirstName());
		
	}

	@Override
	public void delete(User users) {
		System.out.println("AbcProductDao ile silindi "+ users.getFirstName());
		
	}

	@Override
	public User getId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getEmailPassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
