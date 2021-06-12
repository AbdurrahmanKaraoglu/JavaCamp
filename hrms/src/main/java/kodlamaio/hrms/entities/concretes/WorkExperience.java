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
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "work_experiences")
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "company_name")
	@NotBlank(message = "Şirket İsmi Boş Geçilemez")
	private String companyName;

	@Column(name = "started_date")
	@NotBlank(message = "Başlama Tarihi Boş Geçilemez")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate startedDate;

	@Column(name = "ended_date")
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate endedDate;

	@Column(name = "creation_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate creationDate;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name="resume_id")
	private Resume resume;

	@ManyToOne
	@JoinColumn(name = "job_title_id")
	private JobPosition jobPosition;

}