package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.EducationInformation;
import java.util.List;

public interface EducationInformationDao extends JpaRepository<EducationInformation, Integer> {

	/*
	 * @Query("Select new kodlamaio.newhrms.entities.dtos.EducationInformationDto" +
	 * "(edu.id,js.firstName , js.lastName ,er.id, edu.schoolName,edu.schoolDepartment,edu.startedDate,edu.endedDate)"
	 * + "From EducationInformation edu " + "Inner Join edu.resume er " +
	 * "Inner Join JobSeeker js ON edu.resume.jobSeeker.id = js.id where js.id =:jobSeekerId  order by edu.endedDate desc"
	 * )
	 * 
	 * List<EducationInformationDto> getEducationInformationEndedDateDesc(int
	 * jobSeekerId);
	 */

	List<EducationInformation> getAllByResumeIdOrderByEndedDateDesc(int resumeId);
}
