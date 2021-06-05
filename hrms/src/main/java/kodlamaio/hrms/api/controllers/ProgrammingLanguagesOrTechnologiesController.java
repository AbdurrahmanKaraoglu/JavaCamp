package kodlamaio.hrms.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.ProgrammingLanguagesOrTechnologieService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguagesOrTechnologie;

@RestController
@RequestMapping("/api/programminglanguagesortechnologiescontroller")
public class ProgrammingLanguagesOrTechnologiesController {
	private ProgrammingLanguagesOrTechnologieService programmingLanguagesOrTechnologieService;

	@Autowired
	public ProgrammingLanguagesOrTechnologiesController(
			ProgrammingLanguagesOrTechnologieService programmingLanguagesOrTechnologieService) {
		super();
		this.programmingLanguagesOrTechnologieService = programmingLanguagesOrTechnologieService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody ProgrammingLanguagesOrTechnologie programmingLanguagesOrTechnologie) {
		return this.programmingLanguagesOrTechnologieService.add(programmingLanguagesOrTechnologie);
	}

	@GetMapping("/getall")
	public DataResult<List<ProgrammingLanguagesOrTechnologie>> getAll() {
		return this.programmingLanguagesOrTechnologieService.getAll();
	}
}