package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

@Service // 5 -- Bu class projede servis görevi görecek
public class EmployerManager implements EmployerService {

	// Birden fazla olabilir.
	private VerificationService<Employer> verificationService;

	@Autowired // 3 -- Bağımlılık oluşturur.
	public EmployerManager(VerificationService<Employer> verificationService) { // 4
		super();
		this.verificationService = verificationService;
	}

	@Override // 1
	public Result add(Employer employer) {
		return this.verificationService.verifyData(employer);

	}

	@Override // 1
	public DataResult<List<Employer>> getAll() {
		// return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),
		// "Data Listelendi");
		return this.verificationService.getAll();
	}

}

//>>> 4 <<<

// 