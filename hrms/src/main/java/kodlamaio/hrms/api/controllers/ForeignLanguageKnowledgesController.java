package kodlamaio.hrms.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.ForeignLanguageKnowledgeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ForeignLanguageKnowledge;

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
	public Result add(@RequestBody ForeignLanguageKnowledge foreignLanguageKnowledge) {
		return this.foreignLanguageKnowledgeService.add(foreignLanguageKnowledge);
	}

	@GetMapping("/getall")
	public DataResult<List<ForeignLanguageKnowledge>> getAll() {
		return this.foreignLanguageKnowledgeService.getAll();
	}
}