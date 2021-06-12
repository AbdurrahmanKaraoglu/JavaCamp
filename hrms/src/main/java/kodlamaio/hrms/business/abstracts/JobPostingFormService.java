package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPostingForm;
import kodlamaio.hrms.entities.dtos.JobPostingFormDto;
import kodlamaio.hrms.entities.dtos.JobPostingFormGetDto;

public interface JobPostingFormService {
	Result add(JobPostingForm jobPostingForm);
	
	Result delete(JobPostingForm jobPostingForm);

	DataResult<List<JobPostingFormGetDto>> getAll();

	DataResult<List<JobPostingFormDto>> getByIsActive();

	DataResult<List<JobPostingFormDto>> getByIsActiveOrderByReleaseDate();

	DataResult<List<JobPostingFormDto>> getByIsActiveAndEmployer_CompanyName(String companyName);

}