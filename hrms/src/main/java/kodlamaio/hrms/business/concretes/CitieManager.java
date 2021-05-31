package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CitieService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Citie;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CitieDao;

@Service
public class CitieManager implements CitieService{
	private CitieDao citieDao;

	@Autowired
	public CitieManager(CitieDao citieDao) {
		super();
		this.citieDao = citieDao;
	}

	@Override
	public DataResult<List<Citie>> getAll() {
		return new SuccessDataResult<List<Citie>>(this.citieDao.findAll(), "Data Listelendi");
	}

}
