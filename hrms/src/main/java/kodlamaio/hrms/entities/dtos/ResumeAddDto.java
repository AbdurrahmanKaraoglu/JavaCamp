package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeAddDto {
	@JsonProperty(access = Access.READ_ONLY)
	private int id;
	private int jobSeekerId;
	private String githubAddress;
	private String linkedinAddress;
	private String photoAddress;
	private String coverLetter;
	private LocalDate creationDate;
	private LocalDate dateOfUpdate;
}