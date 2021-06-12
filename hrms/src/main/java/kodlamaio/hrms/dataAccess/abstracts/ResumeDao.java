package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer> {
	/*
	 * @Query("Select new kodlamaio.newhrms.entities.dtos.ResumeDto" +
	 * "(js.firstName , js.lastName , edu.schoolName,edu.schoolDepartment,edu.startedDate,edu.endedDate , "
	 * +
	 * "wrkex.companyName,wrkex.startedDate,wrkex.endedDate, frlanguage.foreignLanguageName, frlanguage.foreignLanguageLevel,"
	 * +
	 * "progtecno.programmingOrTechnologyName,rs.coverLetter,rs.githubAddress,rs.linkedinAddress,rs.photo,rs.createdDate,rs.updatedDate ) "
	 * + "From Resume rs " + "Inner Join rs.jobSeeker js" +
	 * "Inner Join rs.workExperiences wrkex " +
	 * "Inner Join rs.educationInformations edu" +
	 * "Inner Join rs.foreignLanguageKnowledges frlanguage " +
	 * "Inner Join rs.programmingLanguagesOrTechnologies progtecno")
	 */

	// List<ResumeDto> getResumeDetails();
	// @Query("From Resume r where r.jobSeeker =: jobSeekerId")
	// List<Resume> getByResumeIdForJobSeekerId(int jobSeekerId);

	List<Resume> getAllByJobSeekerId(int jobSeekerId);
}