package layeredE_commerceBackend.dataAccess.concretes;

import java.util.List;

import layeredE_commerceBackend.dataAccess.abstracts.GoogleDao;
import layeredE_commerceBackend.entities.concretes.SignUpWithGoogle;
import layeredE_commerceBackend.entities.concretes.User;

public class HibernateGoogleDao implements GoogleDao{

	@Override
	public void add(SignUpWithGoogle signUpWithGoogle) {
		System.out.println("Hibernate Google ile eklendi "+ signUpWithGoogle.getEmail());
		
	}

	@Override
	public void update(SignUpWithGoogle signUpWithGoogle) {
		System.out.println("Hibernate Google ile guncellendi "+ signUpWithGoogle.getEmail());
		
	}

	@Override
	public void delete(SignUpWithGoogle signUpWithGoogle) {
		System.out.println("Hibernate Google ile silindi "+ signUpWithGoogle.getEmail());
		
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
