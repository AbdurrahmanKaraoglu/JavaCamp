package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import kodlamaio.hrms.entities.concretes.Employer;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {
	Employer getByCompanyName(String companyName);

	boolean existsByCompanyName(String companyName);

}

//>>> 2 <<<

// Veri erişim katmanı

// extends JpaRepository<Employer, Integer>

// JpaRepository verdiğin veri tipi için yani entity anatosyanı ile süslenmiş nesnenin <Employer> için primary key alanı Integer

// <Employer> ile ilgili crud işlemi hazır.