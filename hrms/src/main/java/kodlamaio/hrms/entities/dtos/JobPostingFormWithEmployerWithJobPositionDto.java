package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingFormWithEmployerWithJobPositionDto {
	private String companyName;

	private String jobPositionName;

	private int numberOfOpenPositions;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate releaseDate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate applicationDeadline;

}
