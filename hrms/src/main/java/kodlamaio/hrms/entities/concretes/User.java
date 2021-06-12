package kodlamaio.hrms.entities.concretes;

import javax.persistence.Transient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "email")
	@NotBlank(message = "EMail Alanı Boş olamaz")
	private String email;

	@Column(name = "password")
	@Size(min = 6, max = 30, message = "Şifre en az 6, en fazla 30 karakterden oluşabilir")
	@NotBlank(message = "Şifre Alanı Boş olamaz")
	private String password;

	@NotBlank(message = "Şifre Alanı Boş olamaz")
	@Transient
	@JsonProperty(access = Access.WRITE_ONLY)
	private String passwordRepeat;

	@JsonIgnore
	@Column(name = "verify")
	private boolean verify = false;

}