package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false) // 8
@Data // 3
@Entity // 4
@Table(name = "employers") // 5 -- Veri tabanında hangi tabloya eşit olacak
@AllArgsConstructor // 7
@NoArgsConstructor // 7
@PrimaryKeyJoinColumn(name = "id")

// İş Verenler
// 1
public class Employer extends User {

	@Column(name = "company_name") // 6 -- Veri tabanındaki tablodaki hangi column a denk geliyor.
	@NotBlank(message = "Şirket Adı Boş Geçilemez")
	private String companyName; // 2

	@Column(name = "web_address") // 6
	@NotBlank(message = "Web Sitesi Boş Geçilemez")
	private String webAddress; // 2

	@Column(name = "phone_number") // 6
	@NotBlank(message = "Telefon Numarası Boş Geçilemez")
	private String phoneNumber; // 2

	@JsonIgnore
	@Column(name = "employer_confirm")
	private boolean isConfirmed;
}

// >>> 1 <<<

// Bir class da birden fazla iş olmayacak
