package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {
	private VerificationService<JobSeeker> verificationService;

	@Autowired
	public JobSeekerManager(VerificationService<JobSeeker> verificationService) {
		super();
		this.verificationService = verificationService;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {

		return this.verificationService.verifyData(jobSeeker);
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {

		return this.verificationService.getAll();
	}

}