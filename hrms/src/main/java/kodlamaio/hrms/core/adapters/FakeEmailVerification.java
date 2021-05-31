package kodlamaio.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.FakeEmailVerificationService;

@Service
public class FakeEmailVerification implements FakeEmailVerificationService {

	public boolean emailVerification(String email) {

		return true;

	}

}
