package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_posting_forms")
@AllArgsConstructor
@NoArgsConstructor

public class JobPostingForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "job_description")
	@NotBlank(message = "İş Açıklaması Boş Geçilemez")
	private String jobDescription;

	@Column(name = "minimum_salary")
	private int minimumSalary;

	@Column(name = "maximum_salary")
	private int maximumSalary;

	@Column(name = "number_of_open_positions")
	@NotBlank(message = "Açık Pozisyon Sayısı Boş Geçilemez")
	private int numberOfOpenPositions;

	@Column(name = "release_date")
	@NotBlank(message = "Yayınlama Tarihi Boş Geçilemez")
	private LocalDate releaseDate;

	@Column(name = "application_deadline")
	@NotBlank(message = "Son Başvuru Tarihi Boş Geçilemez")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate applicationDeadline;

	@Column(name = "active")
	private boolean isActive;

	@ManyToOne(targetEntity = Employer.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "employer_id", referencedColumnName = "id", nullable = false)
	private Employer employer;

	@ManyToOne(targetEntity = Citie.class, fetch = FetchType.LAZY, optional = false)
	@NotBlank(message = "Şehir Boş Geçilemez")
	@JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
	private Citie citie;

	@ManyToOne(targetEntity = JobPosition.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "job_position_id", referencedColumnName = "id", nullable = false)
	@NotBlank(message = "İş Pozisyonu Boş Geçilemez")
	private JobPosition jobPosition;

}
