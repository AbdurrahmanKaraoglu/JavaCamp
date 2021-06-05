package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.ForeignLanguageKnowledgeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ForeignLanguageKnowledgeDao;
import kodlamaio.hrms.entities.concretes.ForeignLanguageKnowledge;

@Service
public class ForeignLanguageKnowledgeManager implements ForeignLanguageKnowledgeService {
	private ForeignLanguageKnowledgeDao foreignLanguageKnowledgeDao;

	@Autowired
	public ForeignLanguageKnowledgeManager(ForeignLanguageKnowledgeDao foreignLanguageKnowledgeDao) {
		super();
		this.foreignLanguageKnowledgeDao = foreignLanguageKnowledgeDao;
	}

	@Override
	public Result add(ForeignLanguageKnowledge foreignLanguageKnowledge) {
		this.foreignLanguageKnowledgeDao.save(foreignLanguageKnowledge);
		return new SuccessResult("Yabancı Dil Bilgileri Eklendi");
	}

	@Override
	public DataResult<List<ForeignLanguageKnowledge>> getAll() {
		return new SuccessDataResult<List<ForeignLanguageKnowledge>>(this.foreignLanguageKnowledgeDao.findAll(), "Data Listelendi");
	}

}
