package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.CitieService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CitieDao;
import kodlamaio.hrms.entities.concretes.Citie;

@Service
public class CitieManager implements CitieService {
	private CitieDao citieDao;

	@Autowired
	public CitieManager(CitieDao citieDao) {
		super();
		this.citieDao = citieDao;
	}

	@Override
	public Result add(Citie citie) {
		this.citieDao.save(citie);
		return new SuccessResult("Şehir Eklendi");
	}

	@Override
	public DataResult<List<Citie>> getAll() {
		return new SuccessDataResult<List<Citie>>(this.citieDao.findAll(), "Data Listelendi");
	}

}