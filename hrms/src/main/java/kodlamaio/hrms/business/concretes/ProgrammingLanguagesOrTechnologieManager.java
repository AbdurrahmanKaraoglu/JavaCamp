package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.ProgrammingLanguagesOrTechnologieService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ProgrammingLanguagesOrTechnologieDao;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguagesOrTechnologie;

@Service
public class ProgrammingLanguagesOrTechnologieManager implements ProgrammingLanguagesOrTechnologieService {
	private ProgrammingLanguagesOrTechnologieDao programmingLanguagesOrTechnologieDao;

	@Autowired
	public ProgrammingLanguagesOrTechnologieManager(
			ProgrammingLanguagesOrTechnologieDao programmingLanguagesOrTechnologieDao) {
		super();
		this.programmingLanguagesOrTechnologieDao = programmingLanguagesOrTechnologieDao;
	}

	@Override
	public Result add(ProgrammingLanguagesOrTechnologie programmingLanguagesOrTechnologie) {
		this.programmingLanguagesOrTechnologieDao.save(programmingLanguagesOrTechnologie);
		return new SuccessResult("Yabancı Dil Bilgileri Eklendi");
	}

	@Override
	public DataResult<List<ProgrammingLanguagesOrTechnologie>> getAll() {
		return new SuccessDataResult<List<ProgrammingLanguagesOrTechnologie>>(
				this.programmingLanguagesOrTechnologieDao.findAll(), "Data Listelendi");
	}

}