package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import kodlamaio.hrms.entities.concretes.JobPostingForm;

@Repository
public interface JobPostingFormDao extends JpaRepository<JobPostingForm, Integer> {

	List<JobPostingForm> getByIsActive(boolean active);

	List<JobPostingForm> getByIsActiveOrderByReleaseDate(boolean active);

	List<JobPostingForm> getByIsActiveAndEmployer_CompanyName(boolean active, String companyName);

	/*
	 * @Modifying
	 * 
	 * @Query("UPDATE JobPostingForm SET isActive = false WHERE id=:id AND employer.id=:employerId"
	 * )
	 * 
	 * int updateJobPostingFormSetIsActiveEmployer_id(@Param("id") int
	 * jobPostingForm_id,
	 * 
	 * @Param("employerId") int employer_id);
	 */
}
