package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.ConfirmEmployer;

public interface ConfirmEmployerDao extends JpaRepository<ConfirmEmployer, Integer> {
	ConfirmEmployer getByEmployer_Id(int employerId);

	boolean existsByEmployer_Id(int employerId);

	List<ConfirmEmployer> getByIsConfirmed(boolean confirmed);

}