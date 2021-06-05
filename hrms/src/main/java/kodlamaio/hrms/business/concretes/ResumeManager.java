package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.cloudinary.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	private CloudinaryService cloudinaryService;

	@Autowired
	public ResumeManager(ResumeDao resumeDao, CloudinaryService cloudinaryService) {
		super();
		this.resumeDao = resumeDao;
		this.cloudinaryService = cloudinaryService;
	}

	@Override
	public DataResult<List<Resume>> getByResumeIdForJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.getByResumeIdForJobSeekerId(jobSeekerId),
				"Data Listelendi");
	}

	@Override
	public Result add(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("Özgeçmiş Eklendi.");
	}

	@Override
	public Result saveImage(MultipartFile file, int resumeId) {
		@SuppressWarnings("unchecked")
		Map<String, String> uploader = (Map<String, String>) cloudinaryService.save(file).getData();
		String imageUrl = uploader.get("url");
		Resume resume = resumeDao.getOne(resumeId);
		resume.setPhotoAddress(imageUrl);
		resumeDao.save(resume);
		return new SuccessResult("Kayıt Başarılı");
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(),
				"Data Listelendi");
	}

}
