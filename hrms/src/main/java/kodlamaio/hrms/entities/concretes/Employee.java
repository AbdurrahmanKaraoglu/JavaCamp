package kodlamaio.hrms.entities.concretes;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor

public class Employee extends User {
	@Column(name = "first_name")
	@NotBlank(message = "Boş Geçilemez")
	@NotNull
	private String firstName;

	@Column(name = "last_name")
	@NotBlank(message = "Boş Geçilemez")
	@NotNull
	private String lastName;

	@OneToMany(mappedBy = "employee")
	@JsonIgnore
	private List<EmployeeConfirm> employeeConfirms;

}
