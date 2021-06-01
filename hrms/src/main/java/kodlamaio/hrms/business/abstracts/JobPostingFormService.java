package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.business.abstracts.JobPostingFormService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPostingForm;
import kodlamaio.hrms.entities.dtos.JobPostingFormWithEmployerWithJobPositionDto;

public interface JobPostingFormService {
	DataResult<List<JobPostingForm>> getAll();

	Result add(JobPostingForm jobPostingForm);

	DataResult<List<JobPostingFormWithEmployerWithJobPositionDto>> getByFormActiveTrue();

	DataResult<List<JobPostingFormWithEmployerWithJobPositionDto>> getPostingFormWithEmployerWithJobPositionDetails();

	DataResult<List<JobPostingFormWithEmployerWithJobPositionDto>> getAllByFormActiveTrueOrderByReleaseDateAsc();

	DataResult<List<JobPostingFormWithEmployerWithJobPositionDto>> getAllByEmployer_IdAndFormActiveTrue(
			int employer_id);

	Result updateJobPostingFormSetformActiveEmployer_id(int jobPostingForm_id, int employer_id);
}
