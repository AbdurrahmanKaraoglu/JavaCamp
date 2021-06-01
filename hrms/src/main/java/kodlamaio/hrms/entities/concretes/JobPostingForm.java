package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

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

	@Column(name = "job_description", nullable = false)
	@NotBlank
	@NotNull
	private String jobDescription;

	@Column(name = "minimum_salary")
	private int minimumSalary;

	@Column(name = "maximum_salary")
	private int maximumSalary;

	@Column(name = "number_of_open_positions", nullable = false)
	@NotBlank
	@NotNull
	private int numberOfOpenPositions;

	@Column(name = "release_date", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotBlank
	@NotNull
	private LocalDate releaseDate;

	@Column(name = "application_deadline", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate applicationDeadline;

	@Column(name = "active")
	@NotBlank
	@NotNull
	private boolean formActive;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	@NotBlank
	@NotNull
	private Employer employer;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	@NotBlank
	@NotNull
	private Citie citie;

	@ManyToOne
	@JoinColumn(name = "job_position_id")
	@NotBlank
	@NotNull
	private JobPosition jobPosition;

}
