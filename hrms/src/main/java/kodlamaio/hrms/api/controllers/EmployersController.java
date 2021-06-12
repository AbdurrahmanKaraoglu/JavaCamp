package kodlamaio.hrms.api.controllers;

import java.util.List;
import javax.validation.Valid;
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

@RestController // 1
@RequestMapping("/api/employers") // 2
public class EmployersController { // Dış dünyanın sistemimizle iletişim kurduğu yer

	private EmployerService employerService; // 4

	@Autowired // 5
	public EmployersController(EmployerService employerService) { // 5
		super();
		this.employerService = employerService;
	}

	@GetMapping("/getall") // 3 -- Tüm verileri listelemek için
	public DataResult<List<Employer>> getAll() {
		return this.employerService.getAll();
	}

	@PostMapping("/add") // 3 -- Veri eklemek için
	public Result add(@Valid @RequestBody Employer employer) {
		return this.employerService.add(employer);
	}


}

//>>> 5 <<<

//  -- /api/employers/getall istek gelirse karşılık verecek yapı

// İstekler iki türlüdür
// 1. Bana veri ver.
// 2. Şu veriyi değiştir.
// 