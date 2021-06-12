package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.EducationInformationService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationInformationDao;
import kodlamaio.hrms.entities.concretes.EducationInformation;
import kodlamaio.hrms.entities.dtos.EducationInformationDto;

@Service
public class EducationInformationManager implements EducationInformationService {

	private EducationInformationDao educationInformationDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public EducationInformationManager(EducationInformationDao educationInformationDao,
			DtoConverterService dtoConverterService) {
		super();
		this.educationInformationDao = educationInformationDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(EducationInformationDto educationInformationDto) {
		this.educationInformationDao.save((EducationInformation) dtoConverterService
				.dtoClassConverter(educationInformationDto, EducationInformation.class));
		return new SuccessResult("Eğitim Bilgileri Eklendi Eklendi");
	}

	@Override
	public DataResult<List<EducationInformationDto>> getAll() {
		return new SuccessDataResult<List<EducationInformationDto>>(
				dtoConverterService.dtoConverter(educationInformationDao.findAll(), EducationInformationDto.class));
	}

	@Override
	public DataResult<List<EducationInformationDto>> getAllByResumeIdOrderByEndedDateDesc(int resumeId) {
		/*
		 * return new SuccessDataResult<List<EducationInformationDto>>(
		 * this.educationInformationDao.getEducationInformationEndedDateDesc(jobSeekerId
		 * ), "Data Listelendi");
		 * 
		 * 
		 */
		return new SuccessDataResult<List<EducationInformationDto>>(
				dtoConverterService.dtoConverter(educationInformationDao.getAllByResumeIdOrderByEndedDateDesc(resumeId),
						EducationInformationDto.class),
				" Data Listelendi");
	}

}