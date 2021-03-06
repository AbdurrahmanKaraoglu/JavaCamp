package kodlamaio.hrms.api.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.WorkExperienceDto;

@CrossOrigin
@RestController
@RequestMapping("/api/workexperiences")
public class WorkExperiencesController {
	private WorkExperienceService workExperienceService;

	@Autowired
	public WorkExperiencesController(WorkExperienceService workExperienceService) {
		super();
		this.workExperienceService = workExperienceService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody WorkExperienceDto jobExperienceDto) {
		return this.workExperienceService.add(jobExperienceDto);
	}

	@GetMapping("/getall")
	public DataResult<List<WorkExperienceDto>> getAll() {
		return this.workExperienceService.getAll();
	}

	@GetMapping("/getallbyresumeidorderbyendeddatedesc")
	public DataResult<List<WorkExperienceDto>> getAllByResumeIdOrderByEndedDateDesc(int resumeId) {
		return this.workExperienceService.getAllByResumeIdOrderByEndedDateDesc(resumeId);
	}

}