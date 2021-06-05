package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import kodlamaio.hrms.entities.abstracts.User;
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
public class JobSeeker extends User {

	@Column(name = "first_name")
	@NotBlank(message = "İsim Alanı Boş olamaz")
	@Size(min = 3, message = "İsim alanında en az 3 karakter kullanmanız gerekiyor")
	@NotNull
	private String firstName;

	@Column(name = "last_name")
	@NotBlank(message = "Soyisim Alanı Boş olamaz")
	@NotNull
	private String lastName;

	@Column(name = "identity_number")
	@NotBlank(message = "TC Kimlik Numarası Alanı Boş Olamaz")
	@Size(min = 11, max = 11, message = "TC Kimlik Numaranızı 11 Haneli Giriniz")
	@NotNull
	private String identificationNumber;

	@Column(name = "birth_year")
	@NotBlank(message = "Doğum Yılı Boş Geçilemez")
	@Size(min = 4, max = 4, message = "Doğum Yılınızı Giriniz")
	@NotNull
	private int dateOfBirth;

}