package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import kodlamaio.hrms.entities.concretes.WorkExperience;
import kodlamaio.hrms.entities.dtos.WorkExperienceDto;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer> {
	@Query("Select new kodlamaio.hrms.entities.dtos.WorkExperienceDto"
			+ "(wexp.id ,wj.title, js.firstName , js.lastName , wexp.companyName , wexp.startedDate , wexp.endedDate)"
			+ "From WorkExperience wexp " + "Inner Join wexp.resume r " + "Inner Join wexp.jobPosition wj "
			+ "Inner Join JobSeeker js ON wexp.resume.jobSeeker.id = js.id "
			+ "where js.id =:jobSeekerId  order by wexp.endedDate desc")
	List<WorkExperienceDto> getWorkExperienceEndedDateDesc(int jobSeekerId);
}