package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.EducationInformation;
import kodlamaio.hrms.entities.dtos.EducationInformationDto;

public interface EducationInformationDao extends JpaRepository<EducationInformation, Integer>{
	@Query("Select new kodlamaio.hrms.entities.dtos.EducationInformationDto"
			+ "(edu.id,js.firstName , js.lastName ,er.id, edu.schoolName,edu.schoolDepartment,edu.startedDate,edu.endedDate)"
			+ "From EducationInformation edu " + "Inner Join edu.resume er "
			+ "Inner Join JobSeeker js ON edu.resume.jobSeeker.id = js.id where js.id =:jobSeekerId  order by edu.endedDate desc")

	List<EducationInformationDto> getEducationInformationEndedDateDesc(int jobSeekerId);
}
