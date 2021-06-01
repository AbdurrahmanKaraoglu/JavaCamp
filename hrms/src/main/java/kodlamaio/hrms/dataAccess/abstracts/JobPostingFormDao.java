package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import kodlamaio.hrms.entities.concretes.JobPostingForm;
import kodlamaio.hrms.entities.dtos.JobPostingFormWithEmployerWithJobPositionDto;

public interface JobPostingFormDao extends JpaRepository<JobPostingForm, Integer> {

	@Query("Select new kodlamaio.hrms.entities.dtos.JobPostingFormWithEmployerWithJobPositionDto"
			+ "(e.companyName , p.title , jpf.numberOfOpenPositions, jpf.releaseDate, jpf.applicationDeadline) "
			+ "From JobPostingForm jpf Inner Join jpf.employer e Inner Join jpf.jobPosition p")
	List<JobPostingFormWithEmployerWithJobPositionDto> getPostingFormWithEmployerWithJobPositionDetails();

	@Query("Select new kodlamaio.hrms.entities.dtos.JobPostingFormWithEmployerWithJobPositionDto"
			+ "(e.companyName , p.title , jpf.numberOfOpenPositions, jpf.releaseDate, jpf.applicationDeadline) "
			+ "From JobPostingForm jpf Inner Join jpf.employer e Inner Join jpf.jobPosition p where jpf.formActive = true")
	List<JobPostingFormWithEmployerWithJobPositionDto> getByFormActiveTrue();

	@Query("Select new kodlamaio.hrms.entities.dtos.JobPostingFormWithEmployerWithJobPositionDto"
			+ "(e.companyName , p.title , jpf.numberOfOpenPositions, jpf.releaseDate, jpf.applicationDeadline) "
			+ "From JobPostingForm jpf Inner Join jpf.employer e Inner Join jpf.jobPosition p where jpf.formActive = true order by jpf.releaseDate asc")
	List<JobPostingFormWithEmployerWithJobPositionDto> getAllByFormActiveTrueOrderByReleaseDateAsc();

	@Query("Select new kodlamaio.hrms.entities.dtos.JobPostingFormWithEmployerWithJobPositionDto"
			+ "(e.companyName , p.title , jpf.numberOfOpenPositions, jpf.releaseDate, jpf.applicationDeadline) "
			+ "From JobPostingForm jpf Inner Join jpf.employer e Inner Join jpf.jobPosition p where jpf.formActive = true")
	List<JobPostingFormWithEmployerWithJobPositionDto> getAllByEmployer_IdAndFormActiveTrue(int employer_id);

	@Modifying
	@Query("UPDATE JobPostingForm SET formActive = false WHERE id=:id AND employer.id=:employer_id")

	int updateJobPostingFormSetformActiveEmployer_id(@Param("id") int jobPostingForm_id,
			@Param("employer_id") int employer_id);

}
