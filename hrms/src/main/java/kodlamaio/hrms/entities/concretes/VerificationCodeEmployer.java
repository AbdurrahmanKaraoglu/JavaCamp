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
@Table(name = "verification_code_employers")
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCodeEmployer extends VerificationCode{

	@Column(name = "employer_id")
	private int employerId;
	
}