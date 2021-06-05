package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingFormWithEmployerWithJobPositionDto {
	@JsonIgnore
	private String companyName;
	private String jobPositionName;
	private int numberOfOpenPositions;
	private LocalDate releaseDate;
	private LocalDate applicationDeadline;

}
