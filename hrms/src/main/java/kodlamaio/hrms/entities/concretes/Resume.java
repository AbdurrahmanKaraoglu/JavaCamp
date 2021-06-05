package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.concretes.EducationInformation;
import kodlamaio.hrms.entities.concretes.ForeignLanguageKnowledge;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguagesOrTechnologie;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.concretes.WorkExperience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "resumes")
@AllArgsConstructor
@NoArgsConstructor
public class Resume {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "github_address")
	private String githubAddress;

	@Column(name = "linkedin_address")
	private String linkedinAddress;

	@Column(name = "photo_address")
	private String photoAddress;

	@Column(name = "cover_letter")
	private String coverLetter;

	@Column(name = "creation_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	// @NotBlank(message = "Boş Geçilemez")
	// @NotNull
	private LocalDate creationDate;

	@Column(name = "date_of_update")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfUpdate;

	@Column(name = "active")
	private boolean active;

	@ManyToOne
	@JoinColumn(name = "candidate_id", referencedColumnName = "id", nullable = false)
	// @NotBlank(message = "Boş Geçilemez")
	// @NotNull
	private JobSeeker jobSeeker;

	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
	@JsonIgnore
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "workExperiences" })
	private List<WorkExperience> workExperiences;

	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
	// @JsonIgnore
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "educationInformations" })
	private List<EducationInformation> educationInformations;

	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
	// @JsonIgnore
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "foreignLanguageKnowledges" })
	private List<ForeignLanguageKnowledge> foreignLanguageKnowledges;

	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
	// @JsonIgnore
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "programmingLanguagesOrTechnologies" })
	private List<ProgrammingLanguagesOrTechnologie> programmingLanguagesOrTechnologies;

}
