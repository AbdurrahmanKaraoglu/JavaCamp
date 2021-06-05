package kodlamaio.hrms.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.EducationInformationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EducationInformation;
import kodlamaio.hrms.entities.dtos.EducationInformationDto;

@RestController
@RequestMapping("/api/educationinformations")
public class EducationInformationsController {
	private EducationInformationService educationInformationService;

	@Autowired
	public EducationInformationsController(EducationInformationService educationInformationService) {
		super();
		this.educationInformationService = educationInformationService;
	}

	@GetMapping("/getEducationInformationEndedDateDesc")
	public DataResult<List<EducationInformationDto>> getEducationInformationEndedDateDesc(
			@RequestParam int jobSeekerId) {
		return this.educationInformationService.getEducationInformationEndedDateDesc(jobSeekerId);
	}

	@PostMapping("/add")
	public Result add(@RequestBody EducationInformation educationInformation) {
		return this.educationInformationService.add(educationInformation);
	}

	@GetMapping("/getAll")
	public DataResult<List<EducationInformation>> getAll() {
		return this.educationInformationService.getAll();
	}
}
