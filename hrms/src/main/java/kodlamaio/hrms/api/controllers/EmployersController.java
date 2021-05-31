package kodlamaio.hrms.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController { // Dış dünyanın sistemimizle iletişim kurduğu yer

	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) { // 5
		super();
		this.employerService = employerService;
	}

	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll() {
		return this.employerService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
		return this.employerService.add(employer);
	}

	@GetMapping("/getByCompanyName")
	public DataResult<Employer> getByCompanyName(String companyName) {
		return this.employerService.getByCompanyName(companyName);
	}

	@GetMapping("/getByEmail")
	public DataResult<Employer> getByEmail(String email) {
		return this.employerService.getByEmail(email);
	}

}
