package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import kodlamaio.hrms.entities.abstracts.VerificationCode;
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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "employer_id")
	private int employerId;
	
	/*
	@ManyToOne()
	@JoinColumn(name = "id")
	private VerificationCode verificationCode;
	
	@ManyToOne()
	@JoinColumn(name = "id")
	private Employer employer;*/
}