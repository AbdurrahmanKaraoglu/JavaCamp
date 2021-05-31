package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "verification_code_candidates")
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCodeCandidate extends VerificationCode{

	@Column(name = "candidate_id")
	private int candidateId;
	
}