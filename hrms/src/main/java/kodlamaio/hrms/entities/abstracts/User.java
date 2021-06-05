package kodlamaio.hrms.entities.abstracts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "email")
	@Email(message = "Lütfen Geçerli Bir Mail Adresi Giriniz")
	@NotBlank(message="Mail Alanı Boş olamaz")
	private String email;

	@Column(name = "password")
	@Size(min=6, max=30, message="Şifre en az 6, en fazla 30 karakterden oluşabilir")
	@NotBlank(message="Şifre Alanı Boş olamaz")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
}
