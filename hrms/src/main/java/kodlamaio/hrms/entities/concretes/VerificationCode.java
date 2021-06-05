package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "verification_codes")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public class VerificationCode {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "code")
	@NotBlank(message="Boş Geçilemez")
	@NotNull
	private String code;

	@Column(name = "is_verified")
	@NotBlank(message="Boş Geçilemez")
	@NotNull
	private boolean isVerified;

	@Column(name = "verified_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate verifiedDate;
}