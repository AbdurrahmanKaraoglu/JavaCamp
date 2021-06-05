package kodlamaio.hrms.entities.concretes;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor

public class Employer extends User {

	@Column(name = "company_name")
	@NotBlank(message="Şirket Adı Boş Geçilemez")
	@NotNull
	private String companyName;

	@Column(name = "web_address")
	@NotBlank(message="Web Sitesi Boş Geçilemez")
	@NotNull
	private String webAddress;

	@Column(name = "phone_number")
	@NotBlank(message="Telefon Numarası Boş Geçilemez")
	@NotNull
	private String phoneNumber;
}
