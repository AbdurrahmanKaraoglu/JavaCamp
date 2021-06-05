package kodlamaio.hrms.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkExperience;
import kodlamaio.hrms.entities.dtos.WorkExperienceDto;

@RestController
@RequestMapping("/api/workexperiences")
public class WorkExperiencesController {
	private WorkExperienceService workExperienceService;

	@Autowired
	public WorkExperiencesController(WorkExperienceService workExperienceService) {
		super();
		this.workExperienceService = workExperienceService;
	}

	@GetMapping("/getWorkExperienceEndedDateDesc")
	public DataResult<List<WorkExperienceDto>> getWorkExperienceEndedDateDesc(@RequestParam int jobSeekerId) {
		return this.workExperienceService.getWorkExperienceEndedDateDesc(jobSeekerId);
	}

	@PostMapping("/add")
	public Result add(@RequestBody WorkExperience workExperience) {
		return this.workExperienceService.add(workExperience);
	}
}