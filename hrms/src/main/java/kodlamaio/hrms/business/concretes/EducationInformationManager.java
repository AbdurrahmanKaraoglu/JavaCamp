package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.EducationInformationService;
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

	@Autowired
	public EducationInformationManager(EducationInformationDao educationInformationDao) {
		super();
		this.educationInformationDao = educationInformationDao;
	}

	@Override
	public DataResult<List<EducationInformationDto>> getEducationInformationEndedDateDesc(int jobSeekerId) {
		return new SuccessDataResult<List<EducationInformationDto>>(
				this.educationInformationDao.getEducationInformationEndedDateDesc(jobSeekerId), "Data Listelendi");
	}

	@Override
	public Result add(EducationInformation educationInformation) {
		this.educationInformationDao.save(educationInformation);
		return new SuccessResult("Eğitim Bilgileri Eklendi Eklendi");
	}

	@Override
	public DataResult<List<EducationInformation>> getAll() {
		return new SuccessDataResult<List<EducationInformation>>(this.educationInformationDao.findAll(),
				"Data Listelendi");
	}

}