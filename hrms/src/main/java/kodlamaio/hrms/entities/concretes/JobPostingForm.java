package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_posting_form")
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "employer_id")
	private int employerId;

	@Column(name = "job_position_id")
	private int jobPositionId;

	@Column(name = "job_description")
	private String jobDescription;

	@Column(name = "city_id")
	private int cityId;

	@Column(name = "minimum_salary")
	private int minimumSalary;

	@Column(name = "maximum_salary")
	private int maximumSalary;

	@Column(name = "number_of_open_positions")
	private int numberOfOpenPositions;

	@Column(name = "release_date")
	private LocalDate releaseDate;

	@Column(name = "application_deadline")
	private LocalDate applicationDeadline;

	@Column(name = "active")
	private boolean active;
}
