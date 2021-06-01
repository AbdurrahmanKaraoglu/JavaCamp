package kodlamaio.hrms.business.concretes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.google.common.base.Strings;
import kodlamaio.hrms.business.abstracts.JobPostingFormService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingFormDao;
import kodlamaio.hrms.entities.concretes.JobPostingForm;
import kodlamaio.hrms.entities.dtos.JobPostingFormWithEmployerWithJobPositionDto;

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

		if (jobPostingForm.getJobPosition() == null) {
			return new ErrorResult("Lütfen İş Pozisyonunu Seçiniz!!!");
		} else if (Strings.isNullOrEmpty(jobPostingForm.getJobDescription())) {
			return new ErrorResult("Lütfen İş Tanımını  Giriniz!!!");
		} else if (jobPostingForm.getCitie() == null) {
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
	public DataResult<List<JobPostingFormWithEmployerWithJobPositionDto>> getByFormActiveTrue() {
		return new SuccessDataResult<List<JobPostingFormWithEmployerWithJobPositionDto>>(
				this.jobPostingFormDao.getByFormActiveTrue(), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobPostingFormWithEmployerWithJobPositionDto>> getPostingFormWithEmployerWithJobPositionDetails() {
		return new SuccessDataResult<List<JobPostingFormWithEmployerWithJobPositionDto>>(
				this.jobPostingFormDao.getPostingFormWithEmployerWithJobPositionDetails(), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobPostingFormWithEmployerWithJobPositionDto>> getAllByFormActiveTrueOrderByReleaseDateAsc() {
		return new SuccessDataResult<List<JobPostingFormWithEmployerWithJobPositionDto>>(
				this.jobPostingFormDao.getAllByFormActiveTrueOrderByReleaseDateAsc(), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobPostingFormWithEmployerWithJobPositionDto>> getAllByEmployer_IdAndFormActiveTrue(
			int employer_id) {
		return new SuccessDataResult<List<JobPostingFormWithEmployerWithJobPositionDto>>(
				this.jobPostingFormDao.getAllByEmployer_IdAndFormActiveTrue(employer_id), "Data Listelendi");
	}

	@Override
	public Result updateJobPostingFormSetformActiveEmployer_id(int jobPostingForm_id, int employer_id) {
		this.jobPostingFormDao.updateJobPostingFormSetformActiveEmployer_id(jobPostingForm_id, employer_id);
		return new SuccessResult(" İlan Pasif Duruma Getirildi");
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama Hataları");
		return errors;
	}

}
