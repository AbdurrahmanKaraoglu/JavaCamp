package kodlamaio.hrms.api.controllers;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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
import kodlamaio.hrms.entities.dtos.JobPostingFormWithEmployerWithJobPositionDto;

@RestController
@RequestMapping("/api/jobpostingforms")
public class JobPostingFormsController {
	
	private JobPostingFormService jobPostingFormService;

	@Autowired
	public JobPostingFormsController(JobPostingFormService jobPostingFormService) {
		super();
		this.jobPostingFormService = jobPostingFormService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPostingForm>> getAll() {
		return this.jobPostingFormService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobPostingForm jobPostingForm) {
		return this.jobPostingFormService.add(jobPostingForm);
	}
	
	@GetMapping("/getByFormActiveTrue")
	public DataResult<List<JobPostingFormWithEmployerWithJobPositionDto>> getByFormActiveTrue(){
		return this.jobPostingFormService.getByFormActiveTrue();
	}
	
	@GetMapping("/getPostingFormWithEmployerWithJobPositionDetails")
	public DataResult<List<JobPostingFormWithEmployerWithJobPositionDto>> getPostingFormWithEmployerWithJobPositionDetails(){
		return this.jobPostingFormService.getPostingFormWithEmployerWithJobPositionDetails();
	}
	
	@GetMapping("/getAllByActiveTrueOrderByReleaseDateAsc")
	public DataResult<List<JobPostingFormWithEmployerWithJobPositionDto>> getAllByFormActiveTrueOrderByReleaseDateAsc(){
		return this.jobPostingFormService.getAllByFormActiveTrueOrderByReleaseDateAsc();
	}
	
	@GetMapping("/getAllByEmployer_IdAndActiveTrue")
	public DataResult<List<JobPostingFormWithEmployerWithJobPositionDto>> getAllByEmployer_IdAndActiveTrue(@RequestParam int employer_id){
		return this.jobPostingFormService.getAllByEmployer_IdAndFormActiveTrue(employer_id);
	}
	
	@PostMapping("/disableJobPosting")
	@Transactional
	public Result updateJobPostingFormSetformActiveEmployer_id(int jobPostingForm_id, int employer_id) {
		return this.jobPostingFormService.updateJobPostingFormSetformActiveEmployer_id(jobPostingForm_id, employer_id);
	}
}