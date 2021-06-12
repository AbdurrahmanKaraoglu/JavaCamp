package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobPostingFormService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingFormDao;
import kodlamaio.hrms.entities.concretes.JobPostingForm;
import kodlamaio.hrms.entities.dtos.JobPostingFormDto;
import kodlamaio.hrms.entities.dtos.JobPostingFormGetDto;

@Service
public class JobPostingFormManager implements JobPostingFormService {
	private JobPostingFormDao jobPostingFormDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public JobPostingFormManager(JobPostingFormDao jobPostingFormDao, DtoConverterService dtoConverterService) {
		super();
		this.jobPostingFormDao = jobPostingFormDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(JobPostingForm jobPostingForm) {
		jobPostingForm.setReleaseDate(LocalDate.now());
		this.jobPostingFormDao.save(jobPostingForm);
		return new SuccessResult("İş İlanı Eklendi.");

	}

	@Override
	public Result delete(JobPostingForm jobPostingForm) {
		this.jobPostingFormDao.delete(jobPostingForm);
		return new SuccessResult("İş İlanı Silme işlemi Tamamlandı");
	}

	@Override
	public DataResult<List<JobPostingFormDto>> getByIsActive() {
		return new SuccessDataResult<List<JobPostingFormDto>>(
				dtoConverterService.dtoConverter(jobPostingFormDao.getByIsActive(true), JobPostingFormDto.class),
				"Aktif İş İlanları Listelendi");

	}

	@Override
	public DataResult<List<JobPostingFormGetDto>> getAll() {
		return new SuccessDataResult<List<JobPostingFormGetDto>>(
				dtoConverterService.dtoConverter(jobPostingFormDao.findAll(), JobPostingFormGetDto.class),
				"Tüm İş İlanları Listelendi");
	}

	@Override
	public DataResult<List<JobPostingFormDto>> getByIsActiveOrderByReleaseDate() {
		return new SuccessDataResult<List<JobPostingFormDto>>(dtoConverterService
				.dtoConverter(jobPostingFormDao.getByIsActiveOrderByReleaseDate(true), JobPostingFormDto.class),
				"Tüm İş İlanları Tarihe Göre Listelendi");
	}

	@Override
	public DataResult<List<JobPostingFormDto>> getByIsActiveAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobPostingFormDto>>(dtoConverterService.dtoConverter(
				jobPostingFormDao.getByIsActiveAndEmployer_CompanyName(true, companyName), JobPostingFormDto.class),
				"Bir Firmaya Ait Tüm Aktif İş İlanları Listelendi.");
	}

	/*
	 * @Override public Result updateJobPostingFormSetIsActiveEmployer_id(int
	 * jobPostingForm_id, int employer_iid) {
	 * this.jobPostingFormDao.updateJobPostingFormSetIsActiveEmployer_id(
	 * jobPostingForm_id, employer_iid); return new
	 * SuccessResult(" İlan Pasif Duruma Getirildi"); }
	 */

}
