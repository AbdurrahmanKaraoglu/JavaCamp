package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.business.abstracts.JobPostingFormService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPostingForm;

public interface JobPostingFormService {
	DataResult<List<JobPostingForm>> getAll();

	Result add(JobPostingForm jobPostingForm);

	DataResult<List<JobPostingFormService>> findByActiveTrue();
}
