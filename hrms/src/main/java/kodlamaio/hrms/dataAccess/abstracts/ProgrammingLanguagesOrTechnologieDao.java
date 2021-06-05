package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ProgrammingLanguagesOrTechnologie;

public interface ProgrammingLanguagesOrTechnologieDao
		extends JpaRepository<ProgrammingLanguagesOrTechnologie, Integer> {

}
