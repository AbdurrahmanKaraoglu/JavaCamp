package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingFormAddDto {
	@JsonIgnore
	private int id;
	private int employerId;
	private int jobPositionId;
	private String jobDescription;
	private int citieId;
	private int minimumSalary;
	private int maximumSalary;
	private int numberOfOpenPositions;
	private LocalDate releaseDate; // yayın tarihi
	private LocalDate applicationDeadline; // son başvuru tarihi
	private boolean active;
}