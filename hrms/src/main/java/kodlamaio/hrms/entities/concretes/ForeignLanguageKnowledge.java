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
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
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

	@Column(name = "foreign_language_name")
	@NotBlank(message = "Yabancı Dil Adı Boş Geçilemez")
	private String foreignLanguageName;

	@Column(name = "foreign_language_level")
	@NotBlank(message = "Yabancı Dil Seviyesi ( 0 - 4 ) Boş Geçilemez")
	private char foreignLanguageLevel;

	@Column(name = "creation_date")
	private LocalDate creationDate;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name = "resume_id")
	private Resume resume;
}