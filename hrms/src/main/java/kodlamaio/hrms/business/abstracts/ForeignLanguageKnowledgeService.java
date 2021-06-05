package kodlamaio.hrms.business.abstracts;

import java.util.List;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ForeignLanguageKnowledge;

public interface ForeignLanguageKnowledgeService {
	Result add(ForeignLanguageKnowledge foreignLanguageKnowledge);

	DataResult<List<ForeignLanguageKnowledge>> getAll();
}
