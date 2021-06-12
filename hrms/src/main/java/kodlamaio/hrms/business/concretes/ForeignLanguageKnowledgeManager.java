package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.ForeignLanguageKnowledgeService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ForeignLanguageKnowledgeDao;
import kodlamaio.hrms.entities.concretes.ForeignLanguageKnowledge;
import kodlamaio.hrms.entities.dtos.ForeignLanguageKnowledgeDto;

@Service
public class ForeignLanguageKnowledgeManager implements ForeignLanguageKnowledgeService {
	
	private ForeignLanguageKnowledgeDao foreignLanguageKnowledgeDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public ForeignLanguageKnowledgeManager(ForeignLanguageKnowledgeDao foreignLanguageKnowledgeDao,
			DtoConverterService dtoConverterService) {
		super();
		this.foreignLanguageKnowledgeDao = foreignLanguageKnowledgeDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(ForeignLanguageKnowledgeDto foreignLanguageKnowledgeDto) {
		this.foreignLanguageKnowledgeDao.save((ForeignLanguageKnowledge) dtoConverterService
				.dtoClassConverter(foreignLanguageKnowledgeDto, ForeignLanguageKnowledge.class));
		return new SuccessResult("Yabancı Dil Bilgileri Eklendi.");
	}

	@Override
	public DataResult<List<ForeignLanguageKnowledgeDto>> getAll() {
		return new SuccessDataResult<List<ForeignLanguageKnowledgeDto>>(this.dtoConverterService.dtoConverter(
				foreignLanguageKnowledgeDao.findAll(), ForeignLanguageKnowledgeDto.class), "Veriler Listelendi.");
	}

}
