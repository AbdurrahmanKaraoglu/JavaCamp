package kodlamaio.hrms.api.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.JobPostingFormService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPostingForm;
import kodlamaio.hrms.entities.dtos.JobPostingFormDto;
import kodlamaio.hrms.entities.dtos.JobPostingFormGetDto;

@CrossOrigin
@RestController
@RequestMapping("/api/jobpostingforms")
public class JobPostingFormsController {

	private JobPostingFormService jobPostingFormService;

	@Autowired
	public JobPostingFormsController(JobPostingFormService jobPostingFormService) {
		super();
		this.jobPostingFormService = jobPostingFormService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobPostingForm jobPostingForm) {
		return this.jobPostingFormService.add(jobPostingForm);
	}

	@GetMapping("/getAll")
	public DataResult<List<JobPostingFormGetDto>> getAll() {
		return this.jobPostingFormService.getAll();
	}

	@GetMapping("/getByIsActive")
	public DataResult<List<JobPostingFormDto>> getByIsActive() {
		return this.jobPostingFormService.getByIsActive();
	}

	@GetMapping("/getByIsActiveOrderByReleaseDate")
	public DataResult<List<JobPostingFormDto>> getByIsActiveOrderByReleaseDate() {
		return this.jobPostingFormService.getByIsActiveOrderByReleaseDate();
	}

	@GetMapping("/getByIsActiveAndEmployerCompanyName")
	public DataResult<List<JobPostingFormDto>> getByIsActiveAndEmployer_CompanyName(@RequestParam String companyName) {
		return this.jobPostingFormService.getByIsActiveAndEmployer_CompanyName(companyName);
	}

	/*
	 * @PostMapping("/disableJobPosting")
	 * 
	 * @Transactional public Result updateJobPostingFormSetIsActiveEmployer_id(int
	 * jobPostingForm_id, int employer_id) { return
	 * this.jobPostingFormService.updateJobPostingFormSetIsActiveEmployer_id(
	 * jobPostingForm_id, employer_id); }
	 */

}
