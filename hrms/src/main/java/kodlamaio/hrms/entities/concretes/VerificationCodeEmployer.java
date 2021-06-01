package kodlamaio.hrms.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "verification_code_employers")
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCodeEmployer extends VerificationCode {

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;

}