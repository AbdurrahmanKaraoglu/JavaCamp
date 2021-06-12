package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

public interface VerificationService<T> {
	Result verifyData(T data);

	DataResult<List<T>> getAll();
}
