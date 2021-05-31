package kodlamaio.hrms.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.CitieService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Citie;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {

	private CitieService citieService;

	@Autowired
	public CitiesController(CitieService citieService) {
		super();
		this.citieService = citieService;
	};

	@GetMapping("/getall")
	public DataResult<List<Citie>> getAll() {
		return this.citieService.getAll();
	}
}
