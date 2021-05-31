package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.hrms.entities.concretes.Citie;

public interface CitieDao extends JpaRepository<Citie, Integer> {

}
