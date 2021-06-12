package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceDto {
	@JsonIgnore
	private int id;
	private String firstName;
	private String lastName;
	private int jobPositionId;
	private String companyName;
	private LocalDate startedDate;
	private LocalDate endedDate;
	private int resumeId;
}