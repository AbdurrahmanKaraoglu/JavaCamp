package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
public class EmployeeConfirmsEmployer extends EmployeeConfirm{

	@Column(name = "employer_id")
	private int employerId;
}
