package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import kodlamaio.hrms.entities.concretes.EducationInformation;
import kodlamaio.hrms.entities.concretes.ForeignLanguageKnowledge;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguagesOrTechnologie;
import kodlamaio.hrms.entities.concretes.WorkExperience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeGetDto {
	@JsonProperty(access = Access.READ_ONLY)
	private int id;
	private int jobSeekerId;
	private String jobSeekerFirstName;
	private String jobSeekerLastName;
	private String photo;
	private String coverLetter;
	private String githubAddress;
	private String linkedinAddress;
	private LocalDate createdDate;
	private LocalDate updatedDate;
	private List<EducationInformation> educationInformations;
	private List<WorkExperience> workExperiences;
	private List<ForeignLanguageKnowledge> foreignLanguageKnowledges;
	private List<ProgrammingLanguagesOrTechnologie> programmingLanguagesOrTechnologies;
}