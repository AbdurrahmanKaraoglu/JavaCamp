package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Citie;

public interface CitieService {
	Result add(Citie citie);

	DataResult<List<Citie>> getAll();
}
