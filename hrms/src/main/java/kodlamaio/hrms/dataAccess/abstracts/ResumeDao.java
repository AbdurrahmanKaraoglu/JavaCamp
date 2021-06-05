package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import kodlamaio.hrms.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer> {
	@Query("From Resume r where r.jobSeeker =: jobSeekerId")
	List<Resume> getByResumeIdForJobSeekerId(int jobSeekerId);
}