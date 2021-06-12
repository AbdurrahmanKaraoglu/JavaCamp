package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private VerificationService<JobPosition> verificationService;

	@Autowired
	public JobPositionManager(VerificationService<JobPosition> verificationService) {
		super();
		this.verificationService = verificationService;
	}

	@Override
	public Result add(JobPosition jobPosition) {
		return verificationService.verifyData(jobPosition);
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return verificationService.getAll();
	}

}