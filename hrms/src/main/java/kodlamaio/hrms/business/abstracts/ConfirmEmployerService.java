package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ConfirmEmployer;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.ConfirmEmployerDto;

public interface ConfirmEmployerService {
	void createConfirmEmployer(Employer employer);

	Result confirmUser(String companyName);

	DataResult<List<ConfirmEmployer>> getAll();

	DataResult<List<ConfirmEmployerDto>> getByIsConfirmed();

}
