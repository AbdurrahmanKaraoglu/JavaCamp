package kodlamaio.hrms.api.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.ForeignLanguageKnowledgeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ForeignLanguageKnowledgeDto;

@RestController
@RequestMapping("/api/foreignlanguageknowledges")
public class ForeignLanguageKnowledgesController {
	private ForeignLanguageKnowledgeService foreignLanguageKnowledgeService;

	@Autowired
	public ForeignLanguageKnowledgesController(ForeignLanguageKnowledgeService foreignLanguageKnowledgeService) {
		super();
		this.foreignLanguageKnowledgeService = foreignLanguageKnowledgeService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody ForeignLanguageKnowledgeDto foreignLanguageKnowledgeDto) {
		return this.foreignLanguageKnowledgeService.add(foreignLanguageKnowledgeDto);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ForeignLanguageKnowledgeDto>> getAll() {
		return this.foreignLanguageKnowledgeService.getAll();
	}
}
