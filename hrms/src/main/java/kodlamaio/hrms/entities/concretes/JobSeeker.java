package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class JobSeeker extends User {

	@NotBlank(message = "İsim Alanı Boş olamaz")
	@Size(min = 3, message = "İsim alanında en az 3 karakter kullanmanız gerekiyor")
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = "Soyisim Alanı Boş olamaz")
	@Column(name = "last_name")
	private String lastName;

	@NotBlank(message = "TC Kimlik Numarası Alanı Boş Olamaz")
	@Size(min = 11, max = 11, message = "TC Kimlik Numaranızı 11 Haneli Giriniz")
	@Column(name = "identity_number")
	private String identificationNumber;

	@NotBlank(message = "Doğum Yılı Boş Geçilemez")
	@Column(name = "birth_year")
	@Size(min = 4, max = 4, message = "Doğum Yılınızı Giriniz")
	private String dateOfBirth;

	/*
	 * public JobSeeker(int id, String email, String password, String firstName,
	 * String lastName, String identificationNumber, int dateOfBirth) { super(id,
	 * email, password); this.firstName = firstName; this.lastName = lastName;
	 * this.identificationNumber = identificationNumber; this.dateOfBirth =
	 * dateOfBirth; }
	 */
	// @OneToMany(mappedBy = "jobSeeker")
	// @JsonIgnore
	// private List<Resume> resumes;

}