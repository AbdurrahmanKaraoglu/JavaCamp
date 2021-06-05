package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import kodlamaio.hrms.entities.concretes.Resume;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "foreign_language_knowledges")
@AllArgsConstructor
@NoArgsConstructor
public class ForeignLanguageKnowledge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// @Column(name = "resume_id")
	// @NotBlank
	// @NotNull
	// private int resumeId;

	@Column(name = "foreign_language_name")
	@NotBlank(message = "Yabancı Dil Adı Boş Geçilemez")
	@NotNull
	private String foreignLanguageName;

	@Column(name = "foreign_language_level")
	@NotBlank(message = "Yabancı Dil Seviyesi ( 0 - 4 ) Boş Geçilemez")
	@NotNull
	private char foreignLanguageLevel;

	@Column(name = "creation_date")
	// @NotBlank(message="Boş Geçilemez")
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate creationDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_id")
	// @NotBlank(message = "Boş Geçilemez")
	// @NotNull
	private Resume resume;
}
