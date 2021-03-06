package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.WorkExperienceDto;

public interface WorkExperienceService {

	Result add(WorkExperienceDto workExperienceDto);

	DataResult<List<WorkExperienceDto>> getAll();

	DataResult<List<WorkExperienceDto>> getAllByResumeIdOrderByEndedDateDesc(int resumeId);
}
