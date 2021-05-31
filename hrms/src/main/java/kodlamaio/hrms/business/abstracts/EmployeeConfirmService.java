package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployeeConfirm;

public interface EmployeeConfirmService {
	DataResult<List<EmployeeConfirm>> getAll();
	Result add(EmployeeConfirm employeeConfirm);
}
