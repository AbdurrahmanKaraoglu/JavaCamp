package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.ConfirmEmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ConfirmEmployer;
import kodlamaio.hrms.entities.dtos.ConfirmEmployerDto;

@CrossOrigin
@RestController
@RequestMapping("/api/employeeconfirmscontrollers")
public class ConfirmEmployersController {

	private ConfirmEmployerService confirmEmployerService;

	public ConfirmEmployersController(ConfirmEmployerService confirmEmployerService) {
		super();
		this.confirmEmployerService = confirmEmployerService;
	}

	@PutMapping("/{companyName}")
	public Result update(@PathVariable("companyName") String companyName) {

		return confirmEmployerService.confirmUser(companyName);
	}

	@GetMapping("/getAll")
	public DataResult<List<ConfirmEmployer>> getAll() {
		return this.confirmEmployerService.getAll();
	}

	@GetMapping("/getByIsConfirmedFalse")
	public DataResult<List<ConfirmEmployerDto>> getByIsConfirmed() {
		return this.confirmEmployerService.getByIsConfirmed();
	}

}
