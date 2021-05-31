package kodlamaio.hrms.api.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.EmployeeConfirmService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployeeConfirm;

@RestController
@RequestMapping("/api/employeeconfirmscontrollers")
public class EmployeeConfirmsController {

	private EmployeeConfirmService employeeConfirmService;

	@Autowired
	public EmployeeConfirmsController(EmployeeConfirmService employeeConfirmService) {
		super();
		this.employeeConfirmService = employeeConfirmService;
	}

	@GetMapping("/getall")
	public DataResult<List<EmployeeConfirm>> getAll() {
		return this.employeeConfirmService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody EmployeeConfirm employeeConfirm) {
		return this.employeeConfirmService.add(employeeConfirm);
	}
}