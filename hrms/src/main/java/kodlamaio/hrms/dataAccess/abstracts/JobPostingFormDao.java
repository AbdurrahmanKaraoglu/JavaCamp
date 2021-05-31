package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import kodlamaio.hrms.business.abstracts.JobPostingFormService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobPostingForm;

public interface JobPostingFormDao extends JpaRepository<JobPostingForm, Integer> {
	@Query("From JobPosition where active=:active")
	DataResult<List<JobPostingFormService>> findByActiveTrue(boolean active);
}
