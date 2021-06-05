package kodlamaio.hrms.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import kodlamaio.hrms.entities.concretes.JobSeeker;
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
public class VerificationCodeCandidate extends VerificationCode {

	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	@NotBlank(message = "Boş Geçilemez")
	@NotNull
	private JobSeeker jobSeeker;

}