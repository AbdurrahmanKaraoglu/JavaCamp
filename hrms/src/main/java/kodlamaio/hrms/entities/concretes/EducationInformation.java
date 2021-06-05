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
import com.sun.istack.NotNull;
import kodlamaio.hrms.entities.concretes.EducationInformation;
import kodlamaio.hrms.entities.concretes.Resume;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "education_informations")
@AllArgsConstructor
@NoArgsConstructor
public class EducationInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "school_name")
	@NotBlank(message = "Okul İsmi Boş Geçilemez")
	@NotNull
	private String schoolName;

	@Column(name = "school_department")
	@NotBlank(message = "Bölüm Boş Geçilemez")
	@NotNull
	private String schoolDepartment;

	@Column(name = "started_date")
	@NotBlank(message = "Başlangıç Tarihi Boş Geçilemez")
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate startedDate;

	@Column(name = "ended_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate endedDate;

	@Column(name = "creation_date")
	@NotBlank(message = "Boş Geçilemez")
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate creationDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_id")
	private Resume resume;
}
