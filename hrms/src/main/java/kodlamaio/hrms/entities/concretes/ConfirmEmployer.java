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
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employer_confirms")
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmEmployer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonIgnore
	private int id;

	@Column(name = "is_confirmed")
	private boolean isConfirmed;

	@Column(name = "confirm_date")
	private LocalDate confirmDate;

	/*
	 * @ManyToOne(targetEntity = Employee.class ,fetch = FetchType.LAZY, optional =
	 * false)
	 * 
	 * @JsonProperty(access = Access.WRITE_ONLY)
	 * 
	 * @JoinColumn(name = "employee_id", referencedColumnName = "id" ,nullable =
	 * false) //@NotBlank(message="Boş Geçilemez") private Employee employee;
	 */

	@Column(name = "employee_id") // burası düzenlenecek
	private int employee;

	@ManyToOne(targetEntity = Employer.class)
	@JoinColumn(name = "employer_id", referencedColumnName = "id")
	// @Column(name = "employer_id")
	private Employer employer;

}