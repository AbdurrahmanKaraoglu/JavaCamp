package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.WorkExperience;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer> {

	/*
	 * @Query("Select new kodlamaio.newhrms.entities.dtos.WorkExperienceDto" +
	 * "(wexp.id ,wj.title, js.firstName , js.lastName , wexp.companyName , wexp.startedDate , wexp.endedDate)"
	 * + "From WorkExperience wexp " + "Inner Join wexp.resume r " +
	 * "Inner Join wexp.jobPosition wj " +
	 * "Inner Join JobSeeker js ON wexp.resume.jobSeeker.id = js.id " +
	 * "where js.id =:jobSeekerId  order by wexp.endedDate desc")
	 */

	/*
	 * @Query("Select kodlamaio.newhrms.entities.dtos.WorkExperienceDto(" +
	 * "w.id, w.companyName, w.startedDate, w.endedDate, p.title, j.firstName, j.lastName) "
	 * + "From WorkExperience w Inner Join Resume c ON w.resume_id.id = c.id " +
	 * "Inner Join JobSeeker j ON w.resume_id.jobSeeker.id = j.id " +
	 * "Inner Join JobPosition p ON w.jobPosition.id = p.id " +
	 * "where w.resume.jobSeeker.id=:jobSeekerId ORDER BY w.endedDate DESC")
	 */

	// List<WorkExperienceDto> getWorkExperienceEndedDateDesc(int jobSeekerId);

	List<WorkExperience> getAllByResumeIdOrderByEndedDateDesc(int resumeId);
}