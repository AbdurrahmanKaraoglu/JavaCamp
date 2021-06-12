package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkExperienceDao;
import kodlamaio.hrms.entities.concretes.WorkExperience;
import kodlamaio.hrms.entities.dtos.WorkExperienceDto;

@Service
public class WorkExperienceManager implements WorkExperienceService {
	private WorkExperienceDao workExperienceDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public WorkExperienceManager(WorkExperienceDao workExperienceDao, DtoConverterService dtoConverterService) {
		super();
		this.workExperienceDao = workExperienceDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(WorkExperienceDto workExperienceDto) {
		workExperienceDao
				.save((WorkExperience) dtoConverterService.dtoClassConverter(workExperienceDto, WorkExperience.class));
		return new SuccessResult("İş Deneyimi Eklendi");
	}

	@Override
	public DataResult<List<WorkExperienceDto>> getAll() {
		return new SuccessDataResult<List<WorkExperienceDto>>(
				this.dtoConverterService.dtoConverter(this.workExperienceDao.findAll(), WorkExperienceDto.class),
				"İş Deneyimleri Listelendi");
	}

	@Override
	public DataResult<List<WorkExperienceDto>> getAllByResumeIdOrderByEndedDateDesc(int resumeId) {
		return new SuccessDataResult<List<WorkExperienceDto>>(this.dtoConverterService
				.dtoConverter(this.workExperienceDao.getAllByResumeIdOrderByEndedDateDesc(resumeId), WorkExperienceDto.class),
				"İş Deneyimleri Tarihe Göre Listelendi");
	}

}
