package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ForeignLanguageKnowledge;

public interface ForeignLanguageKnowledgeDao extends JpaRepository<ForeignLanguageKnowledge, Integer>{

}
