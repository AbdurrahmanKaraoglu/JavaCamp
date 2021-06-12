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
	private LocalDate creationDate;

	@Column(name = "date_of_update")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfUpdate;

	@Column(name = "active")
	private boolean active;

	@ManyToOne(targetEntity = JobSeeker.class)
	@JoinColumn(name = "candidate_id", referencedColumnName = "id", nullable = false)
	private JobSeeker jobSeeker;

	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
	private List<WorkExperience> workExperiences;

	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
	private List<EducationInformation> educationInformations;

	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
	private List<ForeignLanguageKnowledge> foreignLanguageKnowledges;

	@OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
	private List<ProgrammingLanguagesOrTechnologie> programmingLanguagesOrTechnologies;

}