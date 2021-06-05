package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@Table(name = "job_titles")
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	@NotBlank(message="İş Pozisyonu Boş Geçilemez")
	@NotNull
	private String title;

	//@OneToMany(mappedBy = "jobPosition")
	//@JsonIgnore
	//private List<JobPostingForm> jobPostingForms;

}