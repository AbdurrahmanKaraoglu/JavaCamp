package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.cloudinary.CloudinaryService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeAddDto;
import kodlamaio.hrms.entities.dtos.ResumeGetDto;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	private CloudinaryService cloudinaryService;
	private DtoConverterService dtoConverterService;

	@Autowired
	public ResumeManager(ResumeDao resumeDao, CloudinaryService cloudinaryService,
			DtoConverterService dtoConverterService) {
		super();
		this.resumeDao = resumeDao;
		this.cloudinaryService = cloudinaryService;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(ResumeAddDto resumeAddDto) {
		resumeDao.save((Resume) dtoConverterService.dtoClassConverter(resumeAddDto, Resume.class));
		return new SuccessResult("CV Eklendi");
	}

	@Override
	public DataResult<List<ResumeGetDto>> getAll() {
		return new SuccessDataResult<List<ResumeGetDto>>(
				dtoConverterService.dtoConverter(resumeDao.findAll(), ResumeGetDto.class), "CV Bilgileri Listelendi");
	}

	@Override
	public DataResult<List<ResumeGetDto>> getAllByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<ResumeGetDto>>(
				dtoConverterService.dtoConverter(resumeDao.getAllByJobSeekerId(jobSeekerId), ResumeGetDto.class),
				"CV Bilgisi Listelendi");
	}

	@SuppressWarnings("deprecation")
	@Override
	public Result saveImage(MultipartFile file, int resumeId) {
		@SuppressWarnings("unchecked")
		Map<String, String> uploader = (Map<String, String>) cloudinaryService.save(file).getData();
		String imageUrl = uploader.get("url");
		Resume Cv = resumeDao.getOne(resumeId);
		Cv.setPhotoAddress(imageUrl);
		resumeDao.save(Cv);
		return new SuccessResult("Resim Ekleme İşlemi Başarılı");
	}

}