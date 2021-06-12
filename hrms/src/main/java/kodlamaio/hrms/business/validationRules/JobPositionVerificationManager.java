package kodlamaio.hrms.business.validationRules;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionVerificationManager implements VerificationService<JobPosition> {
	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionVerificationManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public Result verifyData(JobPosition jobPosition) {
		if (jobPositionDao.existsByTitle(jobPosition.getTitle())) {
			return new ErrorResult("Bu Pozisyon Daha Önce Kaydedildi");
		}

		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İş Pozisyonu Eklendi");
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Listeleme Başarılı");
	}

}
