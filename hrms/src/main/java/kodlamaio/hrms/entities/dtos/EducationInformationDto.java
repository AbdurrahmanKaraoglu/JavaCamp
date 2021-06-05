package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationInformationDto {
	@JsonIgnore
	private int id;
	private String firstName;
	private String lastName;
	private int resumeId;
	private String schoolName;
	private String schoolDepartment;
	private LocalDate startedDate;
	private LocalDate endedDate;
}