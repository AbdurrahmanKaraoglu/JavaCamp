package kodlamaio.hrms.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "employee_confirms_employers")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeConfirmsEmployer extends EmployeeConfirm {

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	@NotBlank(message="Boş Geçilemez")
	@NotNull
	private Employer employer;

}
