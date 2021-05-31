package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.base.Strings;
import kodlamaio.hrms.business.abstracts.JobPostingFormService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingFormDao;
import kodlamaio.hrms.entities.concretes.JobPostingForm;

@Service
public class JobPostingFormManager implements JobPostingFormService {
	private JobPostingFormDao jobPostingFormDao;

	@Autowired
	public JobPostingFormManager(JobPostingFormDao jobPostingFormDao) {
		super();
		this.jobPostingFormDao = jobPostingFormDao;
	}

	@Override
	public DataResult<List<JobPostingForm>> getAll() {
		return new SuccessDataResult<List<JobPostingForm>>(this.jobPostingFormDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(JobPostingForm jobPostingForm) {

		if (jobPostingForm.getJobPositionId() <= 0) {
			return new ErrorResult("Lütfen İş Pozisyonunu Seçiniz!!!");
		} else if (Strings.isNullOrEmpty(jobPostingForm.getJobDescription())) {
			return new ErrorResult("Lütfen İş Tanımını  Giriniz!!!");
		} else if (jobPostingForm.getCityId() <= 0) {
			return new ErrorResult("Lütfen Şehir Seçiniz!!!");
		} else if (jobPostingForm.getNumberOfOpenPositions() <= 0) {
			return new ErrorResult("Açık Pozisyon Adedini Giriniz!!!");
		} else {
			// O anki zamanı ekleyecek;
			// jobPostingForm.setReleaseDate(java.time.LocalDate.now()); // 2021-05-30
			this.jobPostingFormDao.save(jobPostingForm);
			return new SuccessResult("İş İlanı Eklendi.");
		}

	}

	@Override
	public DataResult<List<JobPostingFormService>> findByActiveTrue() {
		// TODO Auto-generated method stub
		return null;
	}

}
