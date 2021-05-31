package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.abstracts.VerificationCode;

public interface VerificationCodeDao extends JpaRepository<VerificationCode, Integer> {
	VerificationCode findByCode(String code);
}
