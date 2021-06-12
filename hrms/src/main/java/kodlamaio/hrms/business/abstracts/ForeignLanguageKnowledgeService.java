package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ForeignLanguageKnowledgeDto;

public interface ForeignLanguageKnowledgeService {
	Result add(ForeignLanguageKnowledgeDto foreignLanguageKnowledgeDto);

	DataResult<List<ForeignLanguageKnowledgeDto>> getAll();
}
