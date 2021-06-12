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
public class JobPostingFormGetDto {
	@JsonProperty(access = Access.READ_ONLY)
	private int id;
	private String employerCompanyName;
	private String jobPositionTitle;
	private String jobDescription;
	private String citieCityName;
	private int minimumSalary;
	private int maximumSalary;
	private int numberOfOpenPositions;
	private LocalDate releaseDate; // yayın tarihi
	private LocalDate applicationDeadline; // son başvuru tarihi
	private boolean active;
}