package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.ConfirmEmployerService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ConfirmEmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.ConfirmEmployer;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.ConfirmEmployerDto;

@Service
public class ConfirmEmployerManager implements ConfirmEmployerService {
	private ConfirmEmployerDao confirmEmployerDao;
	private EmployerDao employerDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public ConfirmEmployerManager(ConfirmEmployerDao confirmEmployerDao, EmployerDao employerDao,
			DtoConverterService dtoConverterService) {
		super();
		this.confirmEmployerDao = confirmEmployerDao;
		this.employerDao = employerDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public void createConfirmEmployer(Employer employer) {
		ConfirmEmployer cEmployer = new ConfirmEmployer();
		cEmployer.setEmployer(employer);
		cEmployer.setEmployee(5); // burası düzenlenecek
		this.confirmEmployerDao.save(cEmployer);

	}

	@Override
	public Result confirmUser(String companyName) {
		if (!employerDao.existsByCompanyName(companyName)) {
			return new ErrorResult("Şirket Kaydı Bulunamadı");
		}

		if (employerDao.getByCompanyName(companyName).isConfirmed()) {
			return new ErrorResult("Daha önce onaylanmış Şirket");
		}

		Employer employer = new Employer();
		employer = employerDao.getByCompanyName(companyName);
		employer.setConfirmed(true);
		employerDao.save(employer);

		ConfirmEmployer cEmployer = new ConfirmEmployer();
		cEmployer = confirmEmployerDao.getByEmployer_Id(employer.getId());
		cEmployer.setConfirmed(true);
		cEmployer.setConfirmDate(LocalDate.now());
		confirmEmployerDao.save(cEmployer);
		return new SuccessResult("Doğrulama Başarılı");
	}

	@Override
	public DataResult<List<ConfirmEmployer>> getAll() {
		return new SuccessDataResult<List<ConfirmEmployer>>(confirmEmployerDao.findAll(), "Listelendi");

	}

	@Override
	public DataResult<List<ConfirmEmployerDto>> getByIsConfirmed() {
		return new SuccessDataResult<List<ConfirmEmployerDto>>(
				dtoConverterService.dtoConverter(confirmEmployerDao.getByIsConfirmed(false), ConfirmEmployerDto.class),
				"Onaylanmamış İşverenler Listelendi");
	}

}