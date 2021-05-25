package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="job_seekers")
public class JobSeeker {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int UserId;
	
	@Column(name="name")
	private String Name;
	
	@Column(name="surname")
	private int Surname;
	
	@Column(name="identification_number")
	private String IdentificationNumber;
	
	
	@Column(name="year_of_birth")
	private String YearOfBirth;
	
}
