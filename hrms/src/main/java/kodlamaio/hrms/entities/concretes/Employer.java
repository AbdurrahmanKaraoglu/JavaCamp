package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employers")
public class Employer {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int UserId;
	
	@Column(name="company_name")
	private String CompanyName;
	
	@Column(name="website")
	private int Website;
	
	@Column(name="phone")
	private String Phone;
	
}
