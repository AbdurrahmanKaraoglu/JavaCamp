package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import kodlamaio.hrms.entities.concretes.Resume;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "programming_languages_or_technologies")
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguagesOrTechnologie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "programming_or_technology_name")
	// @NotBlank(message="Programlama dilleri veya Teknolojileri Boş Geçilemez")
	// @NotNull
	private String programmingOrTechnologyName;

	@Column(name = "creation_date")
	// @NotBlank(message="Boş Geçilemez")
	// @NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate creationDate;

	// @JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name = "resume_id")
	// @NotBlank(message = "Boş Geçilemez")
	// @NotNull
	private Resume resume;
}
